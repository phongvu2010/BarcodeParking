package ga.hunterdo.barcodeparking.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.hunterdo.barcodeparking.dto.ProfileDTO;
import ga.hunterdo.barcodeparking.service.UploadFile;
import ga.hunterdo.barcodeparking.service.UsernameService;

@RestController
public class UploadController {
	@Autowired
	private UsernameService usernameService;

	@Autowired
	private UploadFile uploadFile;

	@PostMapping(value = {"/upload-file"})
	public String multiUploadFileModel(@ModelAttribute ProfileDTO form, HttpServletRequest request, Principal principal) {
		// Make sure directory exists!
		String UPLOAD_DIR = request.getServletContext().getRealPath("WEB-INF/uploads/");
		File uploadDir = new File(UPLOAD_DIR);
		uploadDir.mkdirs();

		String codeCompany = usernameService.findUser(principal.getName()).getCompany().getCode();
		String uploadFilePath = UPLOAD_DIR + codeCompany + ".jpg";

		try {
			uploadFile.saveUploadedFiles(uploadFilePath, form.getFiles());

			return "Upload successful!";
		} catch (IOException e) {
			e.printStackTrace();

			return "Upload failed!";
		}
	}
}