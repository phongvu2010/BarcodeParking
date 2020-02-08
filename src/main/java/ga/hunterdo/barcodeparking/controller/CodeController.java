package ga.hunterdo.barcodeparking.controller;

//import java.security.Principal;
//import java.text.ParseException;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import ga.hunterdo.barcodeparking.dto.CodeDTO;
//import ga.hunterdo.barcodeparking.service.CodeService;
//import ga.hunterdo.barcodeparking.service.ProfileDetail;

//@Controller
public class CodeController {
//	@Autowired
//	private ProfileDetail profileDetail;
//
//	@Autowired
//	private CodeService codeService;
///*
//	@GetMapping(value = {"/image/{id}"})
//	public void imageBarcode(HttpServletResponse response, @PathVariable("id") String id) throws IOException, WriterException {
//		response.setContentType("image/png");
//		OutputStream outputStream = response.getOutputStream();
//		outputStream.write(ZXingHelper.getBarCodeImage(id, 100, 50));
//		outputStream.flush();
//		outputStream.close();
//	}
//*/
//	@GetMapping(value = {"/list-order"})
//	public String orderList(Model model, Principal principal) { 
//		model.addAttribute("title", "List Code | BAC BINH");
//		model.addAttribute("codeCompany", profileDetail.getCompanyCode(principal.getName()));
//		model.addAttribute("listOrder", codeService.listOrder(principal.getName()));
//
//		/* Get form add codes */
//		CodeDTO code = new CodeDTO();
//		model.addAttribute("code", code);
//
//		return "ordersPage";
//	}
//
//	@PostMapping(value = {"/add-codes"})
//	public String doAddCodes(@ModelAttribute("code") CodeDTO code, HttpServletRequest request, Principal principal) {
//		codeService.addCodes(code.getQtyMoto(), code.getQtyCar(), principal.getName());
//
//		return "redirect:/list-order";
//	}
//
//	@GetMapping(value = {"/list-code"})
//	public String codeList(@RequestParam("d") String date, Model model, Principal principal) throws ParseException {  
//		model.addAttribute("title", "List Code | BAC BINH");
//		model.addAttribute("listCode", codeService.listCode(principal.getName(), date));
//
//		return "codesPage";
//	}
//
//	@GetMapping(value = {"/manage-code"})
//	public String codeManageList(Model model, Principal principal) throws ParseException {  
//		model.addAttribute("title", "List Code | BAC BINH");
//		model.addAttribute("listCode", null);
//
//		return "manageCodePage";
//	}
}