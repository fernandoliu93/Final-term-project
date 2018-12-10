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
import com.example.entity.User;
import com.example.service.AdminService;
import com.example.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String loginPage() {
		return "admin/admin_login";
	}
	
	@RequestMapping(value = "/admin_login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String name = request.getParameter("name").toString();
		Admin temp = adminService.getAdminByName(name);
		if (request.getParameter("password").equals(temp.getPassword())) {
			httpSession.setAttribute("name", name);
			return "redirect:/admin_index";
		} else {
			return "password_wrong";
		}
	}
	
	@RequestMapping(value = "/admin_index", method = RequestMethod.GET)
	public String admin_index(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("name");
		if (name.equals("admin")) {
			List<User> userlist = userService.getAll();
			model.addAttribute("userlist", userlist);
		}
		return "admin/admin_index";
	}
	
	@RequestMapping(value = "/block", method = RequestMethod.POST)
	public String block(Model model, HttpServletRequest request) {
		int userid = Integer.valueOf(request.getParameter("userid").toString());
		adminService.block(userid);
		return "redirect:/admin_index";
	}
	
	@RequestMapping(value = "/open", method = RequestMethod.POST)
	public String open(Model model, HttpServletRequest request) {
		int userid = Integer.valueOf(request.getParameter("userid").toString());
		adminService.open(userid);
		return "redirect:/admin_index";
	}
}
