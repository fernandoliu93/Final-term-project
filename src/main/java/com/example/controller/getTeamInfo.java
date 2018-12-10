package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getTeamInfo {
	public static void getTeams() {
//		ModelAndView showTeams = new ModelAndView("showTeams");
//		showTeams.addObject("name", "Human"); 
		
		//Endpoint to call
		String url ="https://api.mysportsfeeds.com/v1.2/pull/nba/2018-2019-regular/overall_team_standings.json";
		//Encode Username and Password
        String encoding = Base64.getEncoder().encodeToString("ca4a3ff3-5b73-4e62-a834-87d7b3:liufengzhang123".getBytes());
        // TOKEN:PASS
        //Add headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic "+encoding);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		//Make the call
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<NBATeamStanding> response = restTemplate.exchange(url, HttpMethod.GET, request, NBATeamStanding.class);
		NBATeamStanding ts = response.getBody(); 
        System.out.println(ts.toString());
		//Send the object to view
        System.out.println(ts.overallteamstandings);
//        showTeams.addObject("teamStandingEntries", ts.getOverallteamstandings().getTeamstandingsentries());
        
//		return showTeams;
	}
	
	public static void main(String[] args) {
		getTeams();
		
	}
}
