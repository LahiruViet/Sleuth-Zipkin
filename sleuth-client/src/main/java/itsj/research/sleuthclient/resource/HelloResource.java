package itsj.research.sleuthclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest/hello")
public class HelloResource {

    @Autowired
    public RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);

    @GetMapping("/client")
    public String hello(){

        LOGGER.info("before calling server...");
        String response = restTemplate.getForObject("http://localhost:8081/rest/hello/server", String.class);
        LOGGER.info("after calling server...");
        return response;
    }
}
