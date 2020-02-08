package ga.hunterdo.barcodeparking.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import ga.hunterdo.barcodeparking.entity.Companies;
//import ga.hunterdo.barcodeparking.entity.Usernames;
//import ga.hunterdo.barcodeparking.repository.CompanyRepository;
//import ga.hunterdo.barcodeparking.repository.UsernameRepository;

//@Component
public class DataSeedingListener { // implements ApplicationListener<ContextRefreshedEvent> {
//	@Value("${spring.kafka.properties.default.companyCode}")
//	private String companyCode;
//
//	@Value("${spring.kafka.properties.default.companyName}")
//	private String companyName;
//
//	@Value("${spring.kafka.properties.default.userName}")
//	private String userName;
//
//	@Value("${spring.kafka.properties.default.passWord}")
//	private String passWord;
//
//	@Value("${spring.kafka.properties.default.email}")
//	private String email;
//
//	@Value("${spring.kafka.properties.default.role}")
//	private String role;
//
//	@Autowired
//	private CompanyRepository companyRepo;
//
//	@Autowired
//	private UsernameRepository usernameRepo;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	private Companies company;
//	private Usernames username;
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (!companyRepo.findById(companyCode).isPresent()) {
//			company = new Companies(companyCode, companyName);
//			companyRepo.save(company);
//
//			username = new Usernames();
//			username.setUsername(userName);
//			username.setPassword(passwordEncoder.encode(passWord));
//			username.setEmail(email);
//			username.setRole(role);
//			username.setCompany(company);
//			username.setEnabled(true);
//			usernameRepo.save(username);
//		}
//	}
}