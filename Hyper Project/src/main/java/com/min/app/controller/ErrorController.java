package com.min.app.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	
	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);
	
	String erMsg01 = "404 에러 발생";
	String erMsg02 = "500 에러 발생";
	String erTime = "[\t{}]";
	
	@RequestMapping(value="/404", method = RequestMethod.GET)
	public String error404() {
		
		log.info(erTime+erMsg01, new Date());
		return "redirect:/";
//		return "/component/error/error404";
	}
	
	@RequestMapping(value="/500", method = RequestMethod.GET)
	public String error500() {
		log.info(erTime+erMsg02, new Date());
		return "redirect:/";
//		return "/component/error/error500";
	}
}
