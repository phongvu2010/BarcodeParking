package ga.hunterdo.barcodeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hunterdo.barcodeparking.entity.Companies;

@Repository
public interface CompanyRepository extends JpaRepository<Companies, String> {
//	@Query("SELECT u.company FROM Usernames u WHERE u.username = ?1")
//	Companies findByUsername(String userName);
}

//@Query(value = "SELECT c FROM Companies c WHERE c.code = ?1 LIMIT 1", nativeQuery = true)
//Companies findByCode(String code);

//@Query(value = "SELECT e.* FROM customer e ORDER BY e.name DESC", nativeQuery = true)
//List<Customer> findAllOrderByNameDescNative();

//@Query("SELECT e FROM Customer e WHERE e.name = ?1")
//List<Customer> findByName(String name);

//@Query("SELECT e FROM Customer e ORDER BY e.name DESC")
//List<Customer> findAllOrderByNameDesc();

//@Query("SELECT e FROM Customer e WHERE e.name = :name AND e.address = :address")
//List<Customer> findByNameAndAddress(@Param("name") String name, @Param("address") String address);

//@Query("SELECT e FROM Customer e WHERE e.name like ?1")
//List<Customer> findByNameLike(String name);