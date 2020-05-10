package com.portal.employee.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	public void sendEmail() throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xxx@gmail.com", "****"); //Email ID/Pwd for authentication
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("xxx@gmail.com", false)); //From Email Id Here
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("xxx@gmail.com,yyy@gmsil.com")); //To email addresses with comma seperated here
		message.setSubject("Catalog/Employee Service Email");

		message.setText("Hi There!" + "\n \n" + "This is Catalog/Employee Service Email!!!" + "\n \n \n"
				+ "*** DO NOT Reply***");
		message.setSentDate(new Date());

		Transport.send(message);

	}
}
