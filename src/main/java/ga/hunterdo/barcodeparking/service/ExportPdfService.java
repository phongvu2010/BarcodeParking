package ga.hunterdo.barcodeparking.service;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.Barcode39;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import ga.hunterdo.barcodeparking.entity.Codes;

//@Service
public class ExportPdfService {
//	@Autowired
//	private ProfileDetail profileDetail;
//
//	private String imageLogoTenant;
//	private String imageLogoDefault;
//
//	private PdfWriter writer;
//
//	public boolean createPdf(ServletContext context, List<Codes> list, String userName) {
//		String filePath = context.getRealPath("/WEB-INF/reports/");
//		File file = new File(filePath);
//		if (!file.exists())
//			new File(filePath).mkdirs();
//
//		try {
//			Document document = new Document(PageSize.A4, 5, 5, 5, 5);
//			writer = PdfWriter.getInstance(document, new FileOutputStream(file + "/export-codes.pdf"));
//			document.open();
//
//			imageLogoTenant = checkImageExists(context, profileDetail.getCompanyCode(userName) + ".jpg");
//			imageLogoDefault = checkImageExists(context, "van-hanh-mall-logo.png");
//
//			PdfPTable table = new PdfPTable(3);
//			table.setWidthPercentage(100);
//			table.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.getDefaultCell().setBorder(0);
//
//			for (Codes codes : list) {
//				if (!(codes.getUsedDate() != null || (codes.getExpiryDate() != null && codes.getExpiryDate().compareTo(new Date()) <0))) {
//					PdfPCell pdfPCell = new PdfPCell(pdfTicker(context, codes));
//					pdfPCell.setBorder(0);
//					pdfPCell.setPadding(5);
//					pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					pdfPCell.setExtraParagraphSpace(5f);
//					table.addCell(pdfPCell);
//				}
//			}
//
//			table.completeRow();
//			document.add(table);
//			document.close();
//			writer.close();
//
//			return true;
//		} catch (DocumentException | IOException e) {
//			e.printStackTrace();
//
//			return false;
//		}
//	}
//
//	private String checkImageExists(ServletContext context, String fileName) {
//		String filePath = context.getRealPath("/WEB-INF/uploads/") + fileName;
//		File fileLogo = new File(filePath);
//		if (fileLogo.exists())
//			return filePath;
//
//		return null;
//	}
//
//	private PdfPTable pdfTicker(ServletContext context, Codes code) throws DocumentException, IOException {
//		URL fontPath = getClass().getProtectionDomain().getCodeSource().getLocation();
//		BaseFont bf = BaseFont.createFont(fontPath + "/static/fonts/ttf/TIMES.TTF", BaseFont.IDENTITY_H, true);
//		Font font1 = new Font(bf, 9, Font.BOLD);
//		Font font2 = new Font(bf, 8, Font.ITALIC);
//		Font font3 = new Font(bf, 8);
//
//		PdfPTable table = new PdfPTable(1);
//		table.setWidthPercentage(100);
//
//		PdfPCell topLogoCell = new PdfPCell(top2Logo());
//		topLogoCell.setBorder(13);
//		topLogoCell.setPaddingTop(2);
//		table.addCell(topLogoCell);
//
//		String type;
//		if (code.getType().equals(Codes.CAR)) type = "Vé ÔTÔ có giá trị 20.000đ";
//		else type = "Vé XE MÁY có giá trị 4.000đ";
//		PdfPCell typeCell = new PdfPCell(new Paragraph(type, font1));
//		typeCell.setBorder(12);
//		typeCell.setPaddingTop(3);
//		typeCell.setPaddingBottom(7);
//		typeCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(typeCell);
//
//		table.addCell(createBarcode39(code.getCode()));
//
//		PdfPCell commentCell = new PdfPCell(new Paragraph("Mỗi xe chỉ sử dụng được 1 vé/lượt giữ xe", font2));
//		commentCell.setBorder(12);
//		commentCell.setPaddingTop(-7);
//		commentCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(commentCell);
//
//		PdfPCell expiryDateCell = new PdfPCell(new Paragraph("Thẻ có giá trị trong ngày:", font3));
//		expiryDateCell.setBorder(14);
//		expiryDateCell.setPaddingLeft(5);
//		expiryDateCell.setPaddingBottom(6);
//		expiryDateCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//		table.addCell(expiryDateCell);
//
//		return table;
//	}
//
//	private PdfPTable top2Logo() throws BadElementException, MalformedURLException, IOException {
//		PdfPTable table = new PdfPTable(1);
//		if (imageLogoTenant != null) {
//			table = new PdfPTable(2);
//			table.addCell(imageLogo(Image.getInstance(imageLogoTenant)));
//		}
//
//		table.addCell(imageLogo(Image.getInstance(imageLogoDefault)));
//
//		return table;
//	}
//
//	private PdfPCell imageLogo(Image img) {
//		PdfPCell cell = new PdfPCell(img, true);
//		cell.setBorder(0);
//		cell.setPadding(4);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        return cell;
//	}
//
//	private PdfPCell createBarcode39(String code) {
//		PdfContentByte cb = writer.getDirectContent();
//
//		Barcode39 barcode39 = new Barcode39();
//		barcode39.setCode(code);
//
//		Image code39Image = barcode39.createImageWithBarcode(cb, null, BaseColor.WHITE);
//
//		PdfPCell barcodeCell = new PdfPCell(code39Image);
//		barcodeCell.setBorder(12);
//		barcodeCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		return barcodeCell;
//	}
//
//	public void fileDownload(HttpServletResponse response, ServletContext context) throws IOException {
//		String filePath = context.getRealPath("/WEB-INF/reports/export-codes.pdf");
//		File file = new File(filePath);
//		final int BUFFER_SIZE = 4096;
//		if (file.exists()) {
//			FileInputStream inputStream = new FileInputStream(file);
//			String mimeType = context.getMimeType(filePath);
//			response.setContentType(mimeType);
//			response.setHeader("type: 'pdf', base64: true", "attachment; filename=export-codes.pdf");
//
//			OutputStream  outputStream = response.getOutputStream();
//			byte[] buffer = new byte[BUFFER_SIZE];
//			int bytesRead = -1;
//			while ((bytesRead = inputStream.read(buffer)) != -1)
//				outputStream.write(buffer, 0, bytesRead);
//			inputStream.close();
//			outputStream.close();
//			file.delete();
//		}
//	}
}