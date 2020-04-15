package ga.hunterdo.barcodeparking.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Value("${spring.mail.properties.mail.from}")
	private String mailFrom;

	@Value("${spring.mail.properties.mail.name}")
	private String mailName;

	public void sendSimpleMessage(String mailTo, String mailSubject, String mailContent) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailFrom);
		message.setTo(mailTo);
		message.setSubject(mailSubject);
		message.setText(mailContent);
		emailSender.send(message);
	}

	private MimeMessage mimeMessage(String mailTo, String mailSubject, String mailContent, String pathToAttachment) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(new InternetAddress(mailFrom, mailName));
			helper.setTo(mailTo);
			helper.setSubject(mailSubject);

			if (mailContent != null)
				helper.setText(mailContent);

			if (pathToAttachment != null) {
				FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
				if (file.exists())
					helper.addAttachment(file.getFilename(), file);
			}
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return message;
	}

	public void sendMessageWithAttachment(String mailTo, String mailSubject, String mailContent, String pathToAttachment) {
		MimeMessage message = mimeMessage(mailTo, mailSubject, mailContent, pathToAttachment);
		emailSender.send(message);
	}

	public void sendMessageHtmWithAttachment(String mailTo, String mailSubject, String htmlMsg, String pathToAttachment) {
		MimeMessage message = mimeMessage(mailTo, mailSubject, null, pathToAttachment);
		try {
			message.setContent(htmlMsg, "text/html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		emailSender.send(message);
	}

	public void sendMessageHtm(String mailTo, String mailSubject, String htmlMsg) {
		sendMessageHtmWithAttachment(mailTo, mailSubject, htmlMsg, null);
	}

	public void prepareAndSend(String mailTo, String mailSubject, String message) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom(new InternetAddress(mailFrom, mailName));
			helper.setTo(mailTo);
			helper.setSubject(mailSubject);
			helper.setText(message);
			String content = build(message);
			helper.setText(content, true);
		};
		emailSender.send(messagePreparator);
	}

	private String build(String message) {
		Context context = new Context();
		context.setVariable("message", message);

		return templateEngine.process("mailTemplate", context);
    }
}