package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReController {
	@RequestMapping("/one")
	public String one() {
		System.out.println("this is one hamdler");
		return "redirect:/second";
	}

	@RequestMapping("/second")
	public String second() {
		System.out.println("this is second hamdler");
		return "contact";
	}
}
