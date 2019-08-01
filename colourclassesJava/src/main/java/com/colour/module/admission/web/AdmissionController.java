package com.colour.module.admission.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmissionController {
	
	
	@RequestMapping("/display")
	public String display(){
		return "demo";
	}

}
