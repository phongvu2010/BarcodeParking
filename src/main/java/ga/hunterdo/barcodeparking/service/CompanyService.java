package ga.hunterdo.barcodeparking.service;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.hunterdo.barcodeparking.entity.Companies;
import ga.hunterdo.barcodeparking.repository.CompanyRepo;

@Service
@CacheDefaults(cacheName = "companyCache")
public class CompanyService {
	@Autowired
	private CompanyRepo companyRepo;

	@CacheResult
	public Companies findCompany(String code) {
		return companyRepo.findByCode(code);
	}

	@CachePut
	public void save(@CacheKey String code, @CacheValue Companies company) {
		companyRepo.save(company);
	}
}