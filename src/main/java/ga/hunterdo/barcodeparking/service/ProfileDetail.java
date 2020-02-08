package ga.hunterdo.barcodeparking.service;

//import java.util.Calendar;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import ga.hunterdo.barcodeparking.entity.Tokens;
//import ga.hunterdo.barcodeparking.entity.Usernames;
//import ga.hunterdo.barcodeparking.repository.TokenRepository;
//import ga.hunterdo.barcodeparking.repository.UsernameRepository;
//import ga.hunterdo.barcodeparking.util.RandomString;

//@Service
public class ProfileDetail {
//	@Autowired
//	private UsernameRepository usernameRepo;
//
//	@Autowired
//	private TokenRepository tokenRepo;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private EmailService emailService;
//
//	@Value("${spring.kafka.properties.default.domain}")
//	private String domain;
//
//	public String getCompanyCode(String userName) {
//		return usernameRepo.findByUsername(userName).getCompany().getCode();
//	}
//
//	public String getEmail(String userName) {
//		return usernameRepo.findByUsername(userName).getEmail();
//	}
//
//	public boolean changePassword(String userName, String oldPass, String newPass) {
//		Usernames username = usernameRepo.findByUsername(userName);
//		if (passwordEncoder.matches(oldPass, username.getPassword())) {
//			username.setPassword(passwordEncoder.encode(newPass));
//			usernameRepo.changePassword(userName, username.getPassword(), username); 
//
//			return true;
//		}
//
//		return false;
//	}
//
//	public boolean createToken(String email) {
//		Usernames username = usernameRepo.findByEmail(email);
//		if (username != null) {
//			String tokenID = new RandomString(60).nextString();
//			Calendar cal = Calendar.getInstance();
//			Date date = new Date();
//			cal.setTime(date);
//
//			Tokens token = new Tokens();
//			token.setToken(tokenID);
//			token.setType("Forget password");
//			token.setCreatedDate(cal.getTime());
//			cal.roll(Calendar.DATE, 1);
//			token.setActivedDate(cal.getTime());
//			token.setUsername(username);
//			tokenRepo.save(token);
//
//			String mailSubject = "[VHM] Forget password";
//			String htmlMsg = "<img src='" + domain + "/images/van-hanh-mall-logo.png'>"
//							+ "<br /><br />Dear, <b>" + username.getUsername() + "</b>,"
//							+ "<br /><br />We received a request to forget your password. Click the link below to retrieve your password"
//							+ "<br /><a href='" + domain + "/active?token=" + tokenID + "' target='_blank'>Click here</a>"
//							+ "<br /><br />Best regards!";
//			emailService.sendMessageHtm(email, mailSubject, htmlMsg);
//
//			return true;
//		}
//	
//		return false;
//	}
//
//	public Tokens loadToken(String tokenID) {
//		return tokenRepo.findByToken(tokenID);
//	}
//
//	public boolean changeFGPassword(Tokens token) {
//		if (token.getActivedDate().compareTo(new Date()) >= 0 && !token.isStatus()) {
//			String password = new RandomString().nextString();
//			Usernames username = token.getUsername();
//			username.setPassword(passwordEncoder.encode(password));
//			usernameRepo.save(username);
//			tokenRepo.changePassword(token.getID(), new Date(), true);
//
//			String mailSubject = "[VHM] Reset password";
//			String htmlMsg = "<img src='" + domain + "/images/van-hanh-mall-logo.png'>"
//							+ "<br /><br />Dear, <b>" + username.getUsername() + "</b>,"
//							+ "<br /><br />Your password has been changed:"
//							+ "<br />Password: <b>" + password + "</b>"
//							+ "<br />Please change the password when logging in successfully! <a href='" + domain + "' target='_blank'>Login here</a>"
//							+ "<br /><br />Best regards!";
//			emailService.sendMessageHtm(username.getEmail(), mailSubject, htmlMsg);
//
//			return true;
//		}
//
//		return false;
//	}
}