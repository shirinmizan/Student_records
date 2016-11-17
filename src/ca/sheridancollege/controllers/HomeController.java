package ca.sheridancollege.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Student;

@Controller
public class HomeController {

	@RequestMapping("/")
	//model is a one size fits all container. We don't need to worry about session and request
	public String showHome(Model model){
		//this addAttribute methos will ask for name and value and value is an object which in this case a date
		model.addAttribute("rightnow", new Date());
		return "home2";
	}
	
	@RequestMapping("/input")
	//this will run the input and grab information there
	public String showInput(){
		return "input";
	}
	//get the input jsp's value from action processForm and get it as a post method
	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	//add the model and two parameter of type @RequestParam
	public String processForm(Model model, @RequestParam int id, @RequestParam String name){
		Student s = new Student(id, name);   //this should match with the names in jsp file
		//store the student object as a new attribute. Object is student and value is s
		model.addAttribute("student", s);
		return "display";
	}
}
