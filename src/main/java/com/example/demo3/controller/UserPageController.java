package com.example.demo3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo3.data.entity.Users;

@Controller
public class UserPageController {
	@GetMapping("/userPage")
	@PreAuthorize("hasRole('ROLE_USER')") // 追記 ROLE_USERのユーザのみアクセスを許可
	public String userPage() {
		return "userPage";
	}
	
	@GetMapping("/newuser")
	public String getNewUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "newuser";
	}
	
	@PostMapping("/newuser")
	public String registerUser(Users user) {
		return "redirect:/login";
	}
}