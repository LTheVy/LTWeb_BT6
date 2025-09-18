package ltweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	@GetMapping({"/admin", "/admin/"})
	public String home() {
		return "admin/index";
	}	
}
