package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/home")
	public String home(Model model) 
	{
		System.out.println("this is home page");
		model.addAttribute("name", "abid");
		model.addAttribute("id", 111);
		List<String> fri=new ArrayList<String>();
		fri.add("amir");
		fri.add("abid");
		fri.add("rehan");
		model.addAttribute("f",fri);
		return "index";
	}
    @RequestMapping("/about")
    public String about() {
    	System.out.println("this is about page");
    	return "about";
    }
    @RequestMapping("/services")
    public String services() {
    	System.out.println("this is service controller");
    	return "services";
    }
    @RequestMapping("/help")
    public ModelAndView help() {
    	System.out.println("this is help controller");
    	ModelAndView modelAndView=new ModelAndView();
    	modelAndView.addObject("name", "amir");
    	modelAndView.addObject("id", 1111);
    	modelAndView.setViewName("help");
    	LocalDateTime now= LocalDateTime.now();
    	modelAndView.addObject("time", now);
    	
    	//marks
    	List<Integer> li=new ArrayList<Integer>();
    	li.add(111);
    	li.add(112);
    	li.add(113);
    	modelAndView.addObject("marks",li);
    	
    	return modelAndView;
    }
	
}
