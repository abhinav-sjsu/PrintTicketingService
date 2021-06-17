package com.letsstartcoding.springbootrestapiexample.dao;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.TicketRequest;
import com.letsstartcoding.springbootrestapiexample.model.User;
import com.letsstartcoding.springbootrestapiexample.repository.TicketRequestRepository;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

@Service
public class TicketRequestDAO {
	
	@Autowired
	TicketRequestRepository ticketRequestRepository;
	
	@Autowired
	UserDAO userDAO;
	
	/*to save a ticket request*/
	
	MailjetClient client;
    MailjetRequest request;
    MailjetResponse response;
	
	public TicketRequest save(TicketRequest ticketRequest) throws MailjetException, MailjetSocketTimeoutException,Exception {
		
		Long userId = ticketRequest.getUserId();
		
		User user = userDAO.findOne(userId); // find the user
		
		if(user!=null) {
			
			String email = user.getEmail();
			
			System.out.println("Email ID is "+email);
			
			client = new MailjetClient(System.getenv("53beac896d319c1fb6a585a6910cc83c"), System.getenv("1f4eeb04c5852d0c74948503764b5ebb"), new ClientOptions("v3.1"));
		    request = new MailjetRequest(Emailv31.resource)
		    .property(Emailv31.MESSAGES, new JSONArray()
		    .put(new JSONObject()
		    .put(Emailv31.Message.FROM, new JSONObject()
		    .put("Email", email)
		    .put("Name", "Abhinav"))
		    .put(Emailv31.Message.TO, new JSONArray()
		    .put(new JSONObject()
		    .put("Email", email)
		    .put("Name", "Abhinav")))
		    .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
		    .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
		    .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
		    .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
		    response = client.post(request);
		    System.out.println(response.getStatus());
		    System.out.println(response.getData());
		} else {
			throw new Exception("User not Found");
		}
			
		return ticketRequestRepository.save(ticketRequest);
	}

}
