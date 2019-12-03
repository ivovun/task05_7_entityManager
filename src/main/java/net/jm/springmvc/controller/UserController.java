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

	@GetMapping("/list")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "list-users" ;
	}

	@GetMapping(path = {"/create", "/list/create"})
	public String showFormCreate(Model model) {
		model.addAttribute("user", new User());
		return "user-form-create";
	}

	@PostMapping(path = {"/update", "/list/update"})
	public String update(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/user/list";
	}

	@GetMapping(path = {"/update", "/list/update"})
	public String showFormForUpdate(@RequestParam("userId") int userId,
									Model model) {
		model.addAttribute("user", userService.findOne(userId));
		return "user-form";
	}


	@PostMapping(path = {"/create", "/list/create"})
	public String create(@ModelAttribute("user") User user) {
		userService.create(user);
		return "redirect:/user/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int userId) {
		userService.deleteById(userId);
		return "redirect:/user/list";
	}
}
