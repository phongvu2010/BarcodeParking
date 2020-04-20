package ga.hunterdo.barcodeparking.service;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.repository.UsernameRepo;
import ga.hunterdo.barcodeparking.util.ValidateEmail;

@Service
@CacheDefaults(cacheName = "usernameCache")
public class UsernameService {
	@Autowired
	private UsernameRepo usernameRepo;

	@CacheResult
	public Usernames findUser(String strUser) {
		if (new ValidateEmail().isValid(strUser))
			return usernameRepo.findByEmail(strUser);
		else
			return usernameRepo.findByUsername(strUser);
	}

	@CachePut
	public void save(@CacheKey String userName, @CacheValue Usernames username) {
		usernameRepo.save(username);
	}
}