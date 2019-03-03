package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Event;
import com.sample.model.Success;

@RestController
@RequestMapping
public class InboundService {
	
	@Produce(uri = "direct:pingRoute")
    ProducerTemplate pingTemplate;
	
	@Produce(uri = "direct:matchRoute")
    ProducerTemplate matchTemplate;
	
	@RequestMapping(path = "/mqtt/api/ping", method = RequestMethod.GET)
    public String ping() {
		
		Map<String, Object> headers = new HashMap<>();
		headers.put("METHOD", "ping");
		String camelResponse = pingTemplate.requestBodyAndHeaders(pingTemplate.getDefaultEndpoint(), "PING FROM Inbound Service", headers, String.class);
		
		return camelResponse;
	}
	
	@RequestMapping(path = "/mqtt/api/event", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Success event(@RequestBody Event person) {
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("METHOD", "event");
		
		String camelResponse = matchTemplate.requestBodyAndHeaders(matchTemplate.getDefaultEndpoint(), person, headers, String.class);
		
		Success success = new Success();
		
		String comment = "NONE";

        if (camelResponse.equals("1")) {
            comment = "SUCCESS";
        } 
        
        success.setResult(comment);

        return success;
	}

}
