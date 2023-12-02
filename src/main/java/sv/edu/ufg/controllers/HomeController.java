package sv.edu.ufg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/","/index","/home"})
	public String showHome() {
		return "views/home";
	}
}
