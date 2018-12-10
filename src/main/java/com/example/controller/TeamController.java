package com.example.controller;


import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Admin;
import com.example.entity.Game;
import com.example.entity.Team;
import com.example.entity.User;
import com.example.entity.pGame;
import com.example.service.AdminService;
import com.example.service.TeamService;
import com.example.service.UserService;

@Controller
public class TeamController {

	@Autowired
	UserService userService;
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/rank_of_teams", method = RequestMethod.GET)
	public String rank_of_teams(Model model, HttpServletRequest request) {
       
		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("name");
		List<Team> west = teamService.getWestTeamListOrder();
		List<Team> east = teamService.getEastTeamListOrder();
		model.addAttribute("west", west);
		model.addAttribute("east", east);
		return "user/rank_of_teams";
	}
	
	@RequestMapping(value = "/all_teams", method = RequestMethod.GET)
	public String all_teams(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
//		String name = (String) httpSession.getAttribute("name");
		List<Team> all = teamService.getAll();
		model.addAttribute("all", all);
		return "user/all_teams";
	}

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String details(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String team_name = request.getParameter("team_name").toString();
		Team team = teamService.getTeamByName(team_name);
		List<Game> schedules = teamService.getSchedulesGameByTeam(team_name);
		List<pGame> previous = teamService.getPreviousGameByTeam(team_name);
		String name = (String) httpSession.getAttribute("name");
		User user = userService.getUserByName(name);
		int islike = teamService.judgeLike(user.getId(),team_name);
		model.addAttribute("islike", islike);
		model.addAttribute("team", team);
		model.addAttribute("schedules", schedules);
		model.addAttribute("previous", previous);
		return "user/details";
	}
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public String like(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String teamName = request.getParameter("team_name").toString();
		String userName = (String) httpSession.getAttribute("name");
		teamService.like(teamName,userName);
		return "redirect:/all_teams";
	}
	
	@RequestMapping(value = "/dislike", method = RequestMethod.POST)
	public String dislike(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String teamName = request.getParameter("team_name").toString();
		String userName = (String) httpSession.getAttribute("name");
		teamService.dislike(teamName,userName);
		return "redirect:/all_teams";
	}
	
}
