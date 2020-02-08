package ga.hunterdo.barcodeparking.repository;

//import javax.cache.annotation.CacheDefaults;
//import javax.cache.annotation.CacheKey;
//import javax.cache.annotation.CachePut;
//import javax.cache.annotation.CacheResult;
//import javax.cache.annotation.CacheValue;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import ga.hunterdo.barcodeparking.entity.Usernames;

@Repository
//@Transactional
//@CacheDefaults(cacheName = "userCache")
public interface UsernameRepository extends JpaRepository<Usernames, String> {
//	@CacheResult
//	Usernames findByUsername(String userName);

//	@CacheResult
//	Usernames findByEmail(String email);

//	@CachePut
//	@Modifying
//	@Query("UPDATE Usernames SET password = ?2 WHERE username = ?1")
//	void changePassword(@CacheKey String userName, String passWord, @CacheValue Usernames updatedUsername);
}

//@Query("SELECT username, password, email, role, enabled FROM Usernames WHERE username = ?1")
//String findByUsername(String userName);

//@Query("SELECT username FROM Usernames WHERE email = ?1")
//String findByEmail(String email);

//@Modifying
//@Query("UPDATE Usernames SET password = ?2 WHERE username = ?1")
//void changePassword(String userName, String passWord);

//Usernames findByUsername(String userName);

//@Query("SELECT email FROM Usernames WHERE username = ?1")
//String findEmailByUsername(String userName);
