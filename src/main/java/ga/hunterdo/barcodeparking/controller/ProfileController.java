package ga.hunterdo.barcodeparking.controller;

//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import ga.hunterdo.barcodeparking.dto.ProfileDTO;
//import vn.bacbinh.barcode.entity.Usernames;
//import ga.hunterdo.barcodeparking.service.ProfileDetail;
//import ga.hunterdo.barcodeparking.util.ValidateEmail;

//@Controller
public class ProfileController {
//	@Autowired
//	private ProfileDetail profileDetail;
//
//	@GetMapping(value = {"/profile"})
//	public String profile(Model model, Principal principal) {
//		model.addAttribute("title", "Account Info | BAC BINH");
//
//		model.addAttribute("codeCompany", profileDetail.getCompanyCode(principal.getName()));
//		model.addAttribute("email", profileDetail.getEmail(principal.getName()));
//
//		/* Get form profile */
//		ProfileDTO profile = new ProfileDTO();
//		model.addAttribute("profile", profile);
//
//		return "profilePage";
//	}
//
//	@PostMapping(value = {"/change-password"})
//	public String doChangePassword(@ModelAttribute("profile") ProfileDTO profile, Model model, Principal principal) {
//		String oldPassword = profile.getOldPass();
//		String newPassword = profile.getNewPass();
//
//		if (!oldPassword.equals(newPassword)) {
//			if (profileDetail.changePassword(principal.getName(), oldPassword, newPassword))
//				return "redirect:/";
//			else
//				model.addAttribute("error", "Incorrect password");
//		} else
//			model.addAttribute("error", "The same old password");
//
//		return "redirect:/profile";
//	}
//
//	@GetMapping(value = {"/forgot-password"})
//	public String forgotPassword(Model model) {
//		model.addAttribute("title", "Forgot Password | BAC BINH");
//
//		return "forgetPage";
//	}
//
//	@PostMapping(value = {"/forgot-password"})
//	public String doForgotPassword(@ModelAttribute("profile") ProfileDTO profile, Model model) {
//		String email = profile.getEmail();
//		if (new ValidateEmail().isValid(email)) {
//			if (profileDetail.createToken(email))
//				model.addAttribute("success", "Email activation sent to you!");
//			else
//				model.addAttribute("error", "The email not exist!");
//		}
//
//		return "redirect:/forgot-password";
//	}
//
//	@GetMapping(value = {"/active"})
//	public String changeForgotPassword(@RequestParam("token") String tokenID, Model model) {
//		if (profileDetail.changeFGPassword(profileDetail.loadToken(tokenID))) {
//			model.addAttribute("success", "Password has been sent to your email!");
//
//			return "redirect:/login";
//		} else {
//			model.addAttribute("error", "Link expires!");
//
//			return "redirect:/forgot-password";
//		}
//	}
}