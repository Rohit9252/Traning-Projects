package com.spring.mvc;

import javax.servlet.http.HttpServlet;

import com.spring.service.UserService;
import com.spring.user.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContatcController {
	
	@Autowired
	private UserService userservice;

	@RequestMapping("/contact")
	public String showform() {

		return "contact";
	}

	/*
	 * @RequestMapping(path="/processform",method = RequestMethod.POST) public
	 * String handForm(@RequestParam("email") String userEmail,
	 * 
	 * @RequestParam("userName") String uName,
	 * 
	 * @RequestParam("userPassword")String password, Model model) {
	 * 
	 * // HttpServletRequest requet // String email = requet.getParameter("email");
	 * // // System.out.println(email);
	 * 
	 * // System.out.println(userEmail); // System.out.println(uName); //
	 * System.out.println(password);
	 * 
	 * 
	 * User user = new User();
	 * 
	 * user.setEmail(userEmail); user.setUserName(uName);
	 * user.setPassword(password);
	 * 
	 * System.out.println(user);
	 * 
	 * 
	 * // model.addAttribute("name", uName); // model.addAttribute("email",
	 * userEmail); // model.addAttribute("password", password);
	 * 
	 * 
	 * model.addAttribute("user", user);
	 * 
	 * 
	 * return "success"; }
	 */

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handForm(@ModelAttribute User user, Model model) {

		System.out.println(user);
		
		this.userservice.createUser(user);

		return "success";
	}

}
