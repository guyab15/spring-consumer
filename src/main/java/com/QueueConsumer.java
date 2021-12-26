package com;

import java.net.URI;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class QueueConsumer {

	@Value( "${springRestDbUrl}" )
	private String url;
	
	@RabbitListener(queues = {"${queue.name}"})
	    public void receive(@Payload String message) {
	        System.out.println("Message " + message);
	        ObjectMapper mapper = new ObjectMapper();
	        Customer customer = null;
	        try {
				customer = mapper.readValue(message,Customer.class);
				RestTemplate rt = new RestTemplate();
				URI uri = new URI(url);
				ResponseEntity<String> response = rt.postForEntity(uri, customer, String.class);
				if(response.getStatusCodeValue() == 200) {
					System.out.println("success to send message to db service");
				}else {
					System.err.println("faild to send message to db service, the data will disappear "+response);
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
	        

	    }
}
