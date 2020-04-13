package ga.hunterdo.barcodeparking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ga.hunterdo.barcodeparking.dto.OrderListDTO;
import ga.hunterdo.barcodeparking.entity.Codes;
import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.repository.CodeRepo;
import ga.hunterdo.barcodeparking.util.RandomString;

@Service
@CacheDefaults(cacheName = "codeCache")
public class CodeService {
	@Autowired
	private CodeRepo codeRepo;

	@Value("${application.config.default.barcode.format}")
	private String format;

	private String codeCompany;

	/* Find Orders */
	@CacheResult
	public List<OrderListDTO> listOrder(@CacheKey Usernames username) {
		codeCompany = username.getCompany().getCode();

		List<Object[]> list = codeRepo.countsByCompanyLike(codeCompany);
		List<OrderListDTO> listOrder = new ArrayList<>();
		OrderListDTO order = null;
		String dateOld = null;
		for (Object[] o : list) {
			if (!String.valueOf(o[0]).equals(dateOld)) {
				if (dateOld != null)
					listOrder.add(order);
				order = new OrderListDTO();
				order.setDate((Date) o[0]);
			}

			if(String.valueOf(o[1]).equals(Codes.MOTO)) {
				order.setQtyMoto((int) ((long) o[2]));
				order.setUsedMoto((int) ((long) o[3]));
			} else {order.setQtyCar((int) ((long) o[2]));
				order.setUsedCar((int) ((long) o[3]));
			}

			dateOld = String.valueOf(o[0]);
		}
		listOrder.add(order);

		return listOrder;
	}

	/* Find Codes */
	@CacheResult	// @CacheKey 
	public List<Codes> listCode(@CacheKey String date, Usernames username) throws ParseException {
		Date d = new SimpleDateFormat("yyMMdd").parse(date);
		codeCompany = username.getCompany().getCode();

		List<Codes> listCode = codeRepo.findByCompanyLikeAndDate(codeCompany, d);

		return listCode;
	}

	/* Find Code */
	@CacheResult	// @CacheKey 
	public Codes getCode(@CacheKey String codeStr) {
		return codeRepo.findByCode(codeStr);
	}

	/* Add Codes */
	@CacheRemoveAll
	public void addCodes(int qtyMoto, int qtyCar, Usernames username) {
		codeCompany = username.getCompany().getCode();

		Date date = new Date();
		createCode(qtyMoto, Codes.MOTO, date, username);
		createCode(qtyCar, Codes.CAR, date, username);
	}

	private void createCode(int qty, String type, Date date, Usernames username) {
		while (qty > 0)
			if (saveCode(type, date, username))
				qty--;
	}

	@CacheResult
	private boolean saveCode(String type, Date date, Usernames username) {
		String codeStr = type + createCode() + codeCompany;
		if (codeRepo.countByCode(codeStr) == 0) {
			Codes code = new Codes();
			code.setCode(codeStr);	// false
			code.setType(type);	// false
			code.setUsername(username);	// true
			code.setCreatedDate(date);	// false
//			code.setExpiryDate(date);	// true
			code.setExportDate(date);	// true
//			code.setUsedDate(date);	// true
			codeRepo.save(code);

			return true;
		}

		return false;
	}

	/* Create Code */
	private String createCode() {
		char[] charArray = format.toCharArray();

		StringBuilder codeStr = new StringBuilder(charArray.length);
		for (int i = 0; i < charArray.length; i++) {
			String s = String.valueOf(charArray[i]);
			if (s.equals("*"))
				codeStr.append(new RandomString(RandomString.digits).nextString());
			else if (s.equals("!"))
				codeStr.append(new RandomString(RandomString.uppers).nextString());
			else
				codeStr.append(s);
		}

		return codeStr.toString();
	}
}