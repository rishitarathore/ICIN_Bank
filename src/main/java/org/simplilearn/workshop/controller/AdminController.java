package org.simplilearn.workshop.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.Admin;
import org.simplilearn.workshop.service.AccountService;
import org.simplilearn.workshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	private AdminService adminService;
	private AccountService accountService;

	@Autowired
	public AdminController(AdminService adminService, AccountService acccountService) {
		this.adminService = adminService;
		this.accountService = acccountService;
	}
	
	@GetMapping("/")
	public String home() {
			return "home";
	}
	
	@GetMapping("/admin")
	public String login(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}

		map.addAttribute("adminlogin", "adminlogin");
		return "adminLogin";
	}
	
	@GetMapping("/adminr")
	public String signup(ModelMap Map) {
		return "adminRegister";
	}

	@PostMapping("/admin/register")
	public String adminRegisterAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		Admin admin = adminService.findByUsername(username);
		if (admin != null) {
			map.addAttribute("error", "This username already exists. ");
			return "/adminRegister";
		}

		admin = new Admin();
		admin.setId((long) 0);
		admin.setUsername(username);
		admin.setPassword(password);

		adminService.save(admin);
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/login")
	public String loginAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password) {
		
		Admin admin = adminService.findByUsernameAndPassword(username, password);
		if (admin == null) {
			map.addAttribute("errorMessage", "Admin login failed");
			return "adminLogin";
		}
		// store admin id in session
		HttpSession session = request.getSession();
		session.setAttribute("admin_id", admin.getId());
		session.setAttribute("admin_username", username);
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String dashboard(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}

		return "adminDashboard";
	}

	@GetMapping("/admin/userAccountInfo")
	public String userAccountInfo(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		List<Account> list = accountService.list();
		map.addAttribute("list", list);
		return "adminUserAccountInfo";
	}
		
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/";
	}
}
