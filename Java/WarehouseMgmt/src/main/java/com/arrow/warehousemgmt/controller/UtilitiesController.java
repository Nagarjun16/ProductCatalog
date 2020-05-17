package com.arrow.warehousemgmt.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrow.warehousemgmt.service.SendEmailService;

@RestController
public class UtilitiesController {

	@Autowired
	private SendEmailService sendMailService;
	
	@RequestMapping({"/healthcheck"})
	public String peformHealthcheck() {
		return "OK";
	}
	
	@RequestMapping("/sendemail")
	public String sendMail() {
		try {
			sendMailService.sendEmail();
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return "Mail Sent Successfully!";
	}

}
