package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;

@Controller
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("user") String name,@RequestParam("pwd") String pwd)
	{
		ModelAndView model;
		UserService service=new UserService();
		User user1=new User();
		user1.setPassword(pwd);
		user1.setUserName(name);
		if(service.userAut(user1))
		{
			model=new ModelAndView("welcome");
			model.addObject("name",name);
		}
		else
		{
			model=new ModelAndView("LoginServlet");
			String message="Wrong userName or passwod";
			model.addObject("msg",message);
			
		}
		return model;
	}

}
