package org.farm.base.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestRouter {

	
	@RequestMapping("/test")
	public String restTest() {
		return "successs";
	}
	
}
