package ga.hunterdo.barcodeparking.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ga.hunterdo.barcodeparking.entity.Tokens;
import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.repository.TokenRepo;
import ga.hunterdo.barcodeparking.util.RandomString;

@Service
public class TokenService {
	@Autowired
	private TokenRepo tokenRepo;

	@Autowired
	private UsernameService usernameService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${application.config.default.domain}")
	private String domain;

	public boolean createToken(String email) {
		Usernames username = usernameService.findUser(email);
		if (username != null) {
			String tokenID = new RandomString(60).nextString();
			Calendar cal = Calendar.getInstance();
			Date date = new Date();
			cal.setTime(date);

			Tokens token = new Tokens();
			token.setToken(tokenID);
			token.setType("Forget password");
			token.setCreatedDate(cal.getTime());
			cal.roll(Calendar.DATE, 1);
			token.setActivedDate(cal.getTime());
			token.setUsername(username);

			String mailSubject = "[VHM] Forget password";
			String htmlMsg = "<img src='" + domain + "/images/van-hanh-mall-logo.png'>"
							+ "<br /><br />Dear, <b>" + username.getUsername() + "</b>"
							+ "<br /><br />We received a request to forget your password. Click the link below to retrieve your password"
							+ "<br /><a href='" + domain + "/active?token=" + tokenID + "' target='_blank'>Click here</a>"
							+ "<br /><br />Best regards!";
			emailService.sendMessageHtm(email, mailSubject, htmlMsg);

			tokenRepo.save(token);

			return true;
		}

		return false;
	}

	public boolean changeFGPassword(String tokenID) {
		Tokens token = tokenRepo.findByToken(tokenID);
		if (token.getActivedDate().compareTo(new Date()) >= 0 && !token.isStatus()) {
			String password = new RandomString().nextString();
			Usernames username = token.getUsername();
			username.setPassword(passwordEncoder.encode(password));

			token.setActivedDate(new Date());
			token.setStatus(true);

			String mailSubject = "[VHM] Reset password";
			String htmlMsg = "<img src='" + domain + "/images/van-hanh-mall-logo.png'>"
							+ "<br /><br />Dear, <b>" + username.getUsername() + "</b>"
							+ "<br /><br />Your password has been changed: <b>" + password + "</b>"
							+ "<br />Please change the password when logging in successfully! <a href='" + domain + "' target='_blank'>Login here</a>"
							+ "<br /><br />Best regards!";
			emailService.sendMessageHtm(username.getEmail(), mailSubject, htmlMsg);

			usernameService.save(username.getUsername(), username);
			tokenRepo.save(token);

			return true;
		}

		return false;
	}
}