package ltweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ltweb.entitiy.User;
import ltweb.service.UserService;

@Controller
@RequestMapping(path = {"admin/users"})
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("")
	public String list(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "admin/users/list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("user", new User());
		return "admin/users/add";
	}

	@PostMapping("add")
	public String add(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/admin/users";
	}
	
	@GetMapping("edit/{id}")
	public String edit(ModelMap model, @PathVariable("id") int userId) {
		model.addAttribute("user", userService.findById(userId).get());
		return "admin/users/edit";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/admin/users";
	}
	
	
	@GetMapping("delete/{userId}")
	public String delete(@PathVariable("userId") int userId) {
		userService.deleteById(userId);
		return "redirect:/admin/users";
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<User> list = null;

		if (StringUtils.hasText(name)) {
			list = userService.findByUsernameContaining(name);
		} else {
			list = userService.findAll();
		}
		model.addAttribute("users", list);
		return "admin/users/list";
	}
}
