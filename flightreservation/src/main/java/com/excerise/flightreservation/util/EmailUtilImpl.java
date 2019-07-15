package com.excerise.flightreservation.util;

import java.io.File;
import java.net.ConnectException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;


// indicate for Spring to create this class during runtime - so it can be injected to other items
@Component
public class EmailUtilImpl implements EmailUtil {

	//
	@Autowired
	private JavaMailSender sender;
	@Override
	public void sendEmail(String toAddress, String subject, String body, Optional<String> attachmentPath) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(subject);
			if (attachmentPath.isPresent()){
				helper.addAttachment("attachment", new File(attachmentPath.get()));
			}
			sender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@Override
	public ClientResponse sendEmailViaMailgun(String toAddress, String subject, String body) {
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", "9cb1f736ff882e4763e1d186faf2dc94-de7062c6-20b0a90c"));
		WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox1212c0b9b24548d890d82e2a87459553.mailgun.org/messages");
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("from", "Mailgun Sandbox <postmaster@sandbox1212c0b9b24548d890d82e2a87459553.mailgun.org>");
		formData.add("to", toAddress);
		formData.add("subject", subject);
		formData.add("text", body);
		return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
			post(ClientResponse.class, formData);
	}

}
