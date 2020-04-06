package ga.hunterdo.barcodeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Usernames;

@Repository
public interface UsernameRepo extends JpaRepository<Usernames, String> {
	Usernames findByUsername(String userName);

	Usernames findByEmail(String email);
}
//@Modifying
//@Query("UPDATE Usernames SET password = ?2 WHERE username = ?1")
//void changePassword(String userName, String passWord, Usernames updatedUsername);

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
