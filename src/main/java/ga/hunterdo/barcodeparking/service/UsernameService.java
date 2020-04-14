package ga.hunterdo.barcodeparking.service;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.repository.UsernameRepo;
import ga.hunterdo.barcodeparking.util.ValidateEmail;

@Service
@CacheDefaults(cacheName = "usernameCache")
public class UsernameService {
	@Autowired
	private UsernameRepo usernameRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@CacheResult
	public Usernames findUser(String userName) {
		if (new ValidateEmail().isValid(userName))
			return usernameRepo.findByEmail(userName);
		else
			return usernameRepo.findByUsername(userName);
	}

	@CachePut
	public void save(@CacheKey String strUser, @CacheValue Usernames username) {
		usernameRepo.save(username);
	}

	public boolean changePassword(String userName, String oldPass, String newPass) {
		Usernames username = findUser(userName);
		if (passwordEncoder.matches(oldPass, username.getPassword())) {
			username.setPassword(passwordEncoder.encode(newPass));
			updatePassword(userName, username);
//			usernameRepo.changePassword(userName, username.getPassword()); 

			return true;
		}

		return false;
	}

	@CachePut
	private void updatePassword(@CacheKey String userName, @CacheValue Usernames username) {
		usernameRepo.save(username);
	}
}