package ga.hunterdo.barcodeparking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ga.hunterdo.barcodeparking.entity.Companies;
import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.service.CompanyService;
import ga.hunterdo.barcodeparking.service.UsernameService;

@Controller
public class InstallController {
	@Value("${application.config.company.code}")
	private String companyCode;

	@Value("${application.config.user.name}")
	private String userName;

	@Value("${application.config.user.pass}")
	private String passWord;

	@Value("${application.config.user.email}")
	private String email;

	@Value("${application.config.user.role}")
	private String role;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private UsernameService usernameService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private Companies company;
	private Usernames username;

	@GetMapping(value = {"/install"})
	public String install() {
		if (usernameService.findUser(userName) == null) {
			company = companyService.findCompany(companyCode);
			if (company == null) {
				company = new Companies(companyCode);
				companyService.save(companyCode, company);
			}

			username = new Usernames();
			username.setUsername(userName);
			username.setPassword(passwordEncoder.encode(passWord));
			username.setEmail(email);
			username.setRole(role);
			username.setCompany(company);
			username.setEnabled(true);
			usernameService.save(userName, username);
		}

		return "redirect:/";
	}
}