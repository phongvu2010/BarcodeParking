package ga.hunterdo.barcodeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Companies;

@Repository
public interface CompanyRepo extends JpaRepository<Companies, String> {
	Companies findByCode(String code);
}