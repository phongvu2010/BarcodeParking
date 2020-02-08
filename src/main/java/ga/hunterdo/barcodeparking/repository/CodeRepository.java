package ga.hunterdo.barcodeparking.repository;

//import java.util.Date;
//import java.util.List;

//import javax.cache.annotation.CacheResult;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Codes;

@Repository
public interface CodeRepository extends JpaRepository<Codes, String> {
//	@CacheResult(cacheName = "countByCode")
//	@Query("SELECT COUNT(c) FROM Codes c WHERE c.code = ?1")
//	Integer countByCode(String codeStr);

//	@CacheResult(cacheName = "orderCache")
//	@Query("SELECT CAST(c.exportDate AS date), c.type, COUNT(c.type), COUNT(c.usedDate) FROM Codes c"
//			+ " WHERE c.code LIKE %?1 GROUP BY c.type, CAST(c.exportDate AS date)")
//	List<Object[]> countsByCompanyLike(String codeCompany);

//	@CacheResult(cacheName = "codeCache")
//	@Query("SELECT c FROM Codes c WHERE c.code LIKE %?1 AND CAST(c.createdDate AS date) = ?2")
//	List<Codes> findByCompanyLikeAndDate(String codeCompany, Date date);

//	@CacheResult(cacheName = "codeCache")
//	@Query("SELECT c FROM Codes c WHERE c.code = ?1")
//	Codes findByCode(String codeStr);
}

//@Query("SELECT c FROM Codes c WHERE c.code = ?1")
//Codes findByCode(String codeStr);

//@Query("SELECT c FROM Codes c WHERE c.code LIKE %?1 AND CAST(c.createdDate AS date) = ?2")
//List<Codes> findByCompanyLikeAndDate(String codeCompany, Date date);

//@Query("SELECT CAST(c.createdDate AS date), c.type, COUNT(c.type), COUNT(c.usedDate) FROM Codes c"
//	+ " WHERE c.code LIKE %?1 GROUP BY c.type, CAST(c.createdDate AS date)")
//List<Object[]> countsByCompanyLike(String codeCompany);