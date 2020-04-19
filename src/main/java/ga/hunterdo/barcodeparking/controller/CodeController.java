package ga.hunterdo.barcodeparking.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;

import ga.hunterdo.barcodeparking.dto.CodeDTO;
import ga.hunterdo.barcodeparking.entity.Usernames;
import ga.hunterdo.barcodeparking.service.CodeService;
import ga.hunterdo.barcodeparking.service.UsernameService;
import ga.hunterdo.barcodeparking.util.ZXingHelper;

@Controller
public class CodeController {
	@Autowired
	private CodeService codeService;

	@Autowired
	private UsernameService usernameService;

	private Usernames username;

	@PostMapping(value = {"/add-codes"})
	public String doAddCodes(@ModelAttribute("code") CodeDTO code, HttpServletRequest request, Principal principal) {
		username = usernameService.findUser(principal.getName());
		codeService.addCodes(code.getQtyMoto(), code.getQtyCar(), username);

		return "redirect:/list-order";
	}

	@GetMapping(value = {"/image/{id}"})
	public void imageBarcode(HttpServletResponse response, @PathVariable("id") String id) throws IOException, WriterException {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(id, 100, 50));
		outputStream.flush();
		outputStream.close();
	}

	@GetMapping(value = {"/list-order"})
	public String orderList(Model model, Principal principal) {
		username = usernameService.findUser(principal.getName());

		model.addAttribute("title", "List Code");
		model.addAttribute("codeCompany", username.getCompany().getCode());
		model.addAttribute("listOrder", codeService.listOrder(username));

		/* Get form add codes */
		CodeDTO code = new CodeDTO();
		model.addAttribute("code", code);

		return "ordersPage";
	}

	@GetMapping(value = {"/list-code"})
	public String codeList(@RequestParam("d") String date, Model model, Principal principal) throws ParseException {
		username = usernameService.findUser(principal.getName());

		model.addAttribute("title", "List Code");
		model.addAttribute("listCode", codeService.listCode(date, username));

		return "codesPage";
	}
}