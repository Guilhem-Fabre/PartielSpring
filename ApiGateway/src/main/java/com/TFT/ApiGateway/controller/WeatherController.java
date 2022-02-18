package com.TFT.ApiGateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    public String  fallbackMethod(){

        return "Fallback response:: No weather details available temporarily";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getWeather()
    {
        System.out.println("Getting Weathers details");

        String response = restTemplate.exchange("localhost:8080/",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return "Weather [ Weather Details " + response +" ]";
    }

    @RequestMapping(value = "code/{code}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethodInteger")
    public String getWeathersbyCode(@PathVariable int weatherCode)
    {
        System.out.println("Getting weather details for " + weatherCode);

        String response = restTemplate.exchange("localhost:8080/code/{code}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, weatherCode).getBody();

        System.out.println("Response Body " + response);

        return "WeatherCode -  " + weatherCode + " [ Weather Details " + response+" ]";
    }

    @RequestMapping(value = "nom/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethodInteger")
    public String getWeathersByNom(@PathVariable String weatherNom)
    {
        System.out.println("Getting weather details for " + weatherNom);

        String response = restTemplate.exchange("localhost:8080/nom/{nom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, weatherNom).getBody();

        System.out.println("Response Body " + response);

        return "WeatherNom -  " + weatherNom + " [ Weather Details " + response+" ]";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}