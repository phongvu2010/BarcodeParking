package ga.hunterdo.barcodeparking.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HandleErrorController implements ErrorController {
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@GetMapping(value = {"/error"})
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				model.addAttribute("title", "Page Not Found | BAC BINH");
				model.addAttribute("body_title", "404");
				String mess = "<h2 class=\"text-white\">SORRY!</h2>\r\n" 
							+ "<h3 class=\"font-weight-light text-white\">The page you’re looking for was not found.</h3>";

				model.addAttribute("body_message", mess);
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				model.addAttribute("title", "Internal Server Error | BAC BINH");
				model.addAttribute("body_title", "500");
				String mess = "<h2 class=\"text-white\">SORRY!</h2>\r\n" 
							+ "<h3 class=\"font-weight-light text-white\">There is a problem with the resource you are looking for, and it cannot be displayed. Please try again later.</h3>";

				model.addAttribute("body_message", mess);
			}
		}

		return "errorPage";
	}

	@GetMapping(value = {"/403"})
	public String accessDenied(Model model) {
		model.addAttribute("title", "Access Not Granted | BAC BINH");
		model.addAttribute("body_title", "403");
		String mess	= "<h2 class=\"text-white\">SORRY!</h2>\r\n" 
					+ "<h3 class=\"font-weight-light text-white\">The server cannot process the request</h3>";

		model.addAttribute("body_message", mess);

		return "errorPage";
	}
}