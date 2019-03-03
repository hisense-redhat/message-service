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

import com.sample.model.Person;
import com.sample.model.Success;

@RestController
@RequestMapping
public class InboundService {
	
	@Produce(uri = "direct:pingRoute")
    ProducerTemplate pingTemplate;
	
	@Produce(uri = "direct:matchRoute")
    ProducerTemplate matchTemplate;
	
	@RequestMapping(path = "/rest/api/ping", method = RequestMethod.GET)
    public String ping() {
		
		Map<String, Object> headers = new HashMap<>();
		headers.put("METHOD", "ping");
		String camelResponse = pingTemplate.requestBodyAndHeaders(pingTemplate.getDefaultEndpoint(), "PING FROM DEIM Service", headers, String.class);
		
		return camelResponse;
	}
	
	@RequestMapping(path = "/rest/api/match", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Success match(@RequestBody Person person) {
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("METHOD", "match");
		
		String camelResponse = matchTemplate.requestBodyAndHeaders(matchTemplate.getDefaultEndpoint(), person, headers, String.class);
		
		Success success = new Success();
		
		String comment = "NONE";

        if (camelResponse.equals("0")) {
            comment = "NO MATCH";
        } else if (camelResponse.equals("1")) {
            comment = "MATCH";
        } else if (camelResponse.equals("2")) {
            comment = "DONE";
        } else {
            comment = "ERROR";
        }
        
        success.setResult(comment);

        return success;
	}

}
