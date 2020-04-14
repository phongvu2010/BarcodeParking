package ga.hunterdo.barcodeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Tokens;

@Repository
public interface TokenRepo extends JpaRepository<Tokens, String> {

}