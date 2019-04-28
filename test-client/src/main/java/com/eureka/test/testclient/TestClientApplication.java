package com.eureka.test.testclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestClientApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

@RestController
class ConsumerRestController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerRestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public String index() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://test-server/service-instances/", String.class);
        return response.getBody();
    }
}

