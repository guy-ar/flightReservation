package com.excerise.flightreservation.util;

import java.util.Optional;

import com.sun.jersey.api.client.ClientResponse;

public interface EmailUtil {
	void sendEmail(String toAddress, String subject, String body, Optional<String> attachmentPath);
	public ClientResponse sendEmailViaMailgun(String toAddress, String subject, String body);

}
