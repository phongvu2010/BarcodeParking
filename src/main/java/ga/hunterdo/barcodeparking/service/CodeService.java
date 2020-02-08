package ga.hunterdo.barcodeparking.service;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.stereotype.Service;
//
//import ga.hunterdo.barcodeparking.dto.OrderListDTO;
//import ga.hunterdo.barcodeparking.entity.Codes;
//import ga.hunterdo.barcodeparking.entity.Usernames;
//import ga.hunterdo.barcodeparking.repository.CodeRepository;
//import ga.hunterdo.barcodeparking.repository.UsernameRepository;
//import ga.hunterdo.barcodeparking.util.RandomString;

//@Service
public class CodeService {
//	@Autowired
//	private CodeRepository codeRepo;
//
//	@Autowired
//	private UsernameRepository usernameRepo;
//
//	@Value("${spring.kafka.properties.barcode.format}")
//	private String format;
//
//	private String codeCompany;
//
//	/* Add Codes */
//	@CacheEvict(cacheNames = {"orderCache"}, key = "#codeCompany", allEntries = true)
//	public void addCodes(int qtyMoto, int qtyCar, String userName) {
//		Usernames username = usernameRepo.findByUsername(userName);
//		codeCompany = username.getCompany().getCode();
//		Date date = new Date();
//		createCode(qtyMoto, Codes.MOTO, username, date);
//		createCode(qtyCar, Codes.CAR, username, date);
//	}
//
//	private void createCode(int qty, String type, Usernames username, Date date) {
//		while (qty > 0)
//			if (saveCode(type, username, date))
//				qty--;
//	}
//
//	private boolean saveCode(String type, Usernames username, Date date) {
//		String codeStr = type + createCode() + codeCompany;
//		if (codeRepo.countByCode(codeStr) == 0) {
//			Codes code = new Codes();
//			code.setCode(codeStr);	// false
//			code.setType(type);	// false
//			code.setUsername(username);	// true
//			code.setCreatedDate(date);	// false
////			code.setExpiryDate(date);	// true
//			code.setExportDate(date);	// true
////			code.setUsedDate(date);	// true
//			codeRepo.save(code);
//
//			return true;
//		}
//
//		return false;
//	}
//
//	/* Create Code */
//	private String createCode() {
//		char[] charArray = format.toCharArray();
//
//		StringBuilder codeStr = new StringBuilder(charArray.length);
//		for (int i = 0; i < charArray.length; i++) {
//			String s = String.valueOf(charArray[i]);
//			if (s.equals("*"))
//				codeStr.append(new RandomString(RandomString.digits).nextString());
//			else if (s.equals("!"))
//				codeStr.append(new RandomString(RandomString.uppers).nextString());
//			else
//				codeStr.append(s);
//		}
//
//		return codeStr.toString();
//	}
//
//	/* Find Orders */
//	public List<OrderListDTO> listOrder(String userName) {
//		Usernames username = usernameRepo.findByUsername(userName);
//		codeCompany = username.getCompany().getCode();
//
//		List<Object[]> list = codeRepo.countsByCompanyLike(codeCompany);
//		List<OrderListDTO> listOrder = new ArrayList<>();
//		OrderListDTO order = null;
//		String dateOld = null;
//		for (Object[] o : list) {
//			if (!String.valueOf(o[0]).equals(dateOld)) {
//				if (dateOld != null)
//					listOrder.add(order);
//				order = new OrderListDTO();
//				order.setDate((Date) o[0]);
//			}
//
//			if(String.valueOf(o[1]).equals(Codes.MOTO)) {
//				order.setQtyMoto((int) ((long) o[2]));
//				order.setUsedMoto((int) ((long) o[3]));
//			} else {order.setQtyCar((int) ((long) o[2]));
//				order.setUsedCar((int) ((long) o[3]));
//			}
//				
//
//			dateOld = String.valueOf(o[0]);
//		}
//		listOrder.add(order);
//
//		return listOrder;
//	}
//
//	/* Find Codes */
//	public List<Codes> listCode(String userName, String date) throws ParseException {
//		Date d = new SimpleDateFormat("yyMMdd").parse(date);
//		codeCompany = usernameRepo.findByUsername(userName).getCompany().getCode();
//		List<Codes> listCode = codeRepo.findByCompanyLikeAndDate(codeCompany, d);
//
//		return listCode;
//	}
//
//	/* Find Code */
//	public Codes getCode(String codeStr) {
//		return codeRepo.findByCode(codeStr);
//	}
}