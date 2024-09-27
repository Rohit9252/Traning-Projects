package com.spring.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HopmeController {
	
	
	@RequestMapping("/home")
	public String homepage(Model model) {
		System.out.println("This is home url");
		
		
		model.addAttribute("name","Rohit Kumar");
		
		
		List<String> city = new ArrayList<String>();
		
		city.add("punjab");
		city.add("haryana");
		city.add("Delhi");
		
		
		model.addAttribute("f", city);
		
		return  "index";
		
	}
	
	
	@RequestMapping("/about")
	public String abount() {
		
		System.out.println("About Page");
		
		
		return "about";
	}
	
	
	@RequestMapping("/service")
	public String service() {
		
		System.out.println("this is Service Layer");
		
		return "service";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		
		System.out.println("Help Section");
		
		
		ModelAndView md = new ModelAndView();
		
		md.addObject("name", "rohit");
		
		LocalDateTime date = LocalDateTime.now();
		
		
		
		md.setViewName("help");
		md.addObject("time", date);
		
		

		List<String> city = new ArrayList<String>();
		
		city.add("punjab");
		city.add("haryana");
		city.add("Delhi");
		
		
		md.addObject("list", city);
		
		
		return md;
	}
	
	

}
