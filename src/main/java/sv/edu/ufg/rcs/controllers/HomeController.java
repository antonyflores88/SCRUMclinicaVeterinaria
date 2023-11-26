package sv.edu.ufg.rcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/","/index","/home"})
	public String showHome() {
		return "home";		
	}

}
