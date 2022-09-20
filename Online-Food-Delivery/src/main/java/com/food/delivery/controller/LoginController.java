package com.food.delivery.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.delivery.dao.UserRepository;
import com.food.delivery.entity.User;
import com.food.delivery.helper.Message;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register-Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	// handler for registering user
		@PostMapping("/register")
		public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
				@RequestParam(value = "agreement", defaultValue = "false")
				// @ModelAttribute("user") User user = to accept object from client data ,
				// @RequestParam(value = "agreement", defaultValue = "false" = for extra
				// datafield which not matches with User variable object
				boolean agreement, Model model, HttpSession session) {

			try {
				if (!agreement) {
					System.out.println("You have not agreed terms and conditions");
					throw new Exception("You have not agreed terms and conditions");
				}
				
				if(result.hasErrors()) {
					System.out.println("ERROR " + result.toString());
					model.addAttribute("user", user); 
					return "signup";
				}

//				user.setRole("ROLE_USER");
				user.setRoleId(2L);
//				user.setEnabled(true);
				System.out.println("agreement" + agreement);
				System.out.println("User" + user);

				User result1 = this.userRepository.save(user);

				model.addAttribute("user", new User());
				session.setAttribute("message", new Message("successfully registerd !!!", "alert-success"));
				return "signup";

			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("user", user);
				session.setAttribute("message", new Message("Something went wrong !!!" + e.getMessage(), "alert-danger"));
				return "signup";
			}
		}
}
