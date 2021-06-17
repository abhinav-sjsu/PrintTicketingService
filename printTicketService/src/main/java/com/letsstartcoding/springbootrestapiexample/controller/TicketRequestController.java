package com.letsstartcoding.springbootrestapiexample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.TicketRequestDAO;
import com.letsstartcoding.springbootrestapiexample.model.TicketRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

@RestController
@RequestMapping("/company")
public class TicketRequestController {
	
	@Autowired
	TicketRequestDAO ticketRequestDAO;
	
	/* to save a user*/
	@PostMapping("/ticketRequests")
	public TicketRequest createTicketRequest(@Valid @RequestBody TicketRequest ticketRequest) throws MailjetException, MailjetSocketTimeoutException,Exception {
		return ticketRequestDAO.save(ticketRequest);
	}

}
