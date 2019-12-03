package net.jm.springmvc.controller;

import net.jm.springmvc.entity.User;
import net.jm.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

//	@Autowired
//	public void setUserService( UserService userService) {
//		this.userService = userService;
//	}

	@GetMapping("/list")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "list-users" ;
	}

	@GetMapping(path = {"/showForm", "/list/showForm"})
	public String showFormForAdd(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}
	
	@PostMapping(path = {"/saveUser", "/list/saveUser"})
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("userId") int userId,
									Model model) {
		model.addAttribute("user", userService.getUser(userId));
		return "user-form";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		userService.deleteUser(userId);
		return "redirect:/user/list";
	}
}
