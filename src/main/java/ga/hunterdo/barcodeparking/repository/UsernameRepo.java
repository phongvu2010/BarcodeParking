package ga.hunterdo.barcodeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Usernames;

@Repository
public interface UsernameRepo extends JpaRepository<Usernames, String> {
	Usernames findByUsername(String userName);

	Usernames findByEmail(String email);
}