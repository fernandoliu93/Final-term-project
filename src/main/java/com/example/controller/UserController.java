package com.example.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Admin;
import com.example.entity.Favorite;
import com.example.entity.User;
import com.example.entity.pGame;
import com.example.service.AdminService;
import com.example.service.TeamService;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "user/user_login";
	}
	
	@RequestMapping(value = "/user_login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String name = request.getParameter("name").toString();
		User temp = userService.getUserByName(name);
		if(name.equals("admin")&&request.getParameter("password").equals("admin")){
			httpSession.setAttribute("name", name);
			return "redirect:/admin_index";
		}else{
			if (request.getParameter("password").equals(temp.getPassword())) {
				httpSession.setAttribute("name", name);
				return "redirect:/user_index";
			} else {
				return "password_wrong";
			}
		}
	}
	
	@RequestMapping(value = "/user_index", method = RequestMethod.GET)
	public String admin_index(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("name")!=null) {
			String name = (String) httpSession.getAttribute("name");
			User temp = userService.getUserByName(name);
			List<Favorite> favorites = teamService.getFavoriteTeam(temp.getId());
			List<pGame> today = teamService.getTodayGames("10-27");
			model.addAttribute("favorites",favorites);
			model.addAttribute("today",today);
		}
		return "user/user_index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest request) {
//		HttpSession httpSession = request.getSession();
//		if (httpSession.getAttribute("name")!=null) {
//			String name = (String) httpSession.getAttribute("name");
//			User temp = userService.getUserByName(name);
//			List<Favorite> favorites = teamService.getFavoriteTeam(temp.getId());
//			List<pGame> today = teamService.getTodayGames("10-27");
//			model.addAttribute("favorites",favorites);
//			model.addAttribute("today",today);
//		}

		return "user/register";
	}
	
	@RequestMapping(value = "/re", method = RequestMethod.POST)
	public String re(Model model, HttpServletRequest request) {
		String name = request.getParameter("name").toString();
		String password = request.getParameter("password").toString();
		userService.creat(name, password);
		return "user/user_login";
	}

	
}
