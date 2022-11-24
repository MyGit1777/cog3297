package com.dataloaderportal.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendOTPMail(String subject, String message, String toRecepient) {

		boolean flag = false;

		String from = "dataLoaderPortal@notify.com";

		String host = "smtp.gmail.com";

		Properties props = System.getProperties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jadhavavin.777@gmail.com", "csbtytmpezzargau");
			}
		});
		session.setDebug(true);
		MimeMessage mimessage = new MimeMessage(session);

		try {

			mimessage.setFrom(from);
			mimessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toRecepient));
			mimessage.setSubject(subject);
			mimessage.setText(message);

			Transport.send(mimessage);
			flag = true;

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return flag;

	}
}
