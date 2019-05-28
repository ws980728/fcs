package com.fcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author chen
 *
 */
@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String hello() {
		return "hello";
	}
	
}
