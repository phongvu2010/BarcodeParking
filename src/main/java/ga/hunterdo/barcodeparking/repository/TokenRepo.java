package ga.hunterdo.barcodeparking.repository;

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Tokens;

@Repository
public interface TokenRepo extends JpaRepository<Tokens, String> {
	Tokens findByToken(String tokenID);

//	@Modifying
//	@Query("UPDATE Tokens SET actived_date = ?2, status = ?3 WHERE id = ?1")
//	void changePassword(int tokenID, Date date, boolean status);
}