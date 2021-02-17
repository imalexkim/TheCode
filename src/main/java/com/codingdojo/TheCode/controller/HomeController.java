package com.codingdojo.TheCode.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="answer") String answer, RedirectAttributes redirectAttributes) {
		if(answer.equals("bushido")) {
			return "code.jsp";	
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You must train harder");
			return "redirect:/";
		}
	}
}

