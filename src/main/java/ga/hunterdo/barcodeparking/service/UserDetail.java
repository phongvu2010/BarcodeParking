package ga.hunterdo.barcodeparking.service;

//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import ga.hunterdo.barcodeparking.entity.Usernames;
//import ga.hunterdo.barcodeparking.repository.UsernameRepository;
//import ga.hunterdo.barcodeparking.util.ValidateEmail;

//@Service
public class UserDetail { // implements UserDetailsService {
//	@Autowired
//	private UsernameRepository usernameRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String strUser) {
//		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
//		Usernames username = loadUser(strUser);
//
//		if (username == null) {
//			System.out.println("User " + strUser + " was not found in the database");
//			throw new UsernameNotFoundException("User " + strUser + " was not found in the database");
//		} else {
//			if (!username.isEnabled()) {
//				System.out.println("User " + strUser + " was not enabled");
//				throw new UsernameNotFoundException("User " + strUser + " was not enabled");
//			} else
//				grantedAuthority.add(new SimpleGrantedAuthority(username.getRole()));
//		}
//
//		return new User(username.getUsername(), username.getPassword(), grantedAuthority);
//	}
//
//	private Usernames loadUser(String strUser) {
//		if (new ValidateEmail().isValid(strUser))
//			return usernameRepo.findByEmail(strUser);
//		else
//			return usernameRepo.findByUsername(strUser);
//	}
}