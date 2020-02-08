package ga.hunterdo.barcodeparking.controller;

//import java.io.IOException;
//import java.security.Principal;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

//import ga.hunterdo.barcodeparking.entity.Codes;
//import ga.hunterdo.barcodeparking.service.CodeService;
//import ga.hunterdo.barcodeparking.service.ExportPdfService;

//@Controller
public class PdfController {
//	@Autowired
//	private CodeService codeService;
//
//	@Autowired
//	private ExportPdfService exportPdfService;
//
//	@Autowired
//	private ServletContext context;
//
//	@RequestMapping(value = {"/export-codes"})
//	public void exportCodes(@RequestParam("d") String date, HttpServletResponse response, Principal principal) {
//		try {
//			List<Codes> list = codeService.listCode(principal.getName(), date);
//			boolean isFlag = exportPdfService.createPdf(context, list, principal.getName());
//			if (isFlag)
//				exportPdfService.fileDownload(response, context);
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = {"/export-code"})
//	public void exportCode(@RequestParam("c") String codeStr, HttpServletResponse response, Principal principal) {
//		try {
//			List<Codes> list = new ArrayList<Codes>(0);
//			list.add(codeService.getCode(codeStr));
//			boolean isFlag = exportPdfService.createPdf(context, list, principal.getName());
//			if (isFlag)
//				exportPdfService.fileDownload(response, context);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}