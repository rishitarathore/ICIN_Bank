package org.simplilearn.workshop.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.service.AccountService;
import org.simplilearn.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private UserService userService;
	private AccountService accountService;

	@Autowired
	public UserController(UserService userService, AccountService accountService) {
		this.userService = userService;
		this.accountService = accountService;
	}

	@GetMapping("/user")
	public String login(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		map.addAttribute("userlogin", "userlogin");
		return "userLogin";
	}

	@PostMapping("/user/login")
	public String loginAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		User user = userService.findByUsernameAndPassword(username, password);
		if (user == null) {

			map.addAttribute("errorMessage", "User login failed");
			return "userLogin";
		} else if (user != null && !user.isAuthorizationStatus()) {
			map.addAttribute("errorMessage", "Authorization Pending");
			return "userLogin";
		} else if (user != null && !user.isStatus()) {
			map.addAttribute("user", user);
			return "userBlocked";
		} else {
			// store user id in session
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user.getId());
			session.setAttribute("user_username", username);
			return "redirect:/user/dashboard";
		}
	}

	@GetMapping("/user/dashboard")
	public String dashboard(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userDashboard";
		}
	}

	@GetMapping("/register")
	public String signup(ModelMap map) {
		return "userRegister";
	}

	@PostMapping("/user/register")
	public String registerAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "dob", required = true) Date dob,
			@RequestParam(value = "phone", required = true) Long phone,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "address", required = true) String address,
//			@RequestParam(value="identityType", required=true) String identityType,
			@RequestParam(value = "identity", required = true) String identity) {

		User user = userService.findByUsername(username);
		if (user != null) {
			map.addAttribute("error", "This username already exists. ");
			return "/userRegister";
		}
		user = new User();
		user.setId((long) 0);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setDob(dob);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		// user.setIdentityType(identityType);
		user.setIdentity(identity);
		user.setUsername(username);
		user.setPassword(password);

		userService.saveUser(user);

		return "redirect:/user/registerConfirm";
	}

	@GetMapping("/user/editprofile")
	public String editProfile(ModelMap map, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		User user = userService.findByUsername(session.getAttribute("user_username").toString());
		map.addAttribute("user", user);
		return "userEditProfile";
	}

	@PostMapping("/user/editProfileAction")
	public String editProfileAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "phone", required = true) Long phone,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "address", required = true) String address) {

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		User user = userService.findByUsername(session.getAttribute("user_username").toString());
		map.addAttribute("user", user);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		userService.saveUser(user);

		// update session
		session.setAttribute("user_username", user.getUsername());
		return "userEditProfConfirm";
	}

	@GetMapping("/user/changePassword")
	public String changePassword(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		User user = userService.findById((long) session.getAttribute("user_id"));
		map.addAttribute("user", user);
		return "userChangePassword";
	}

	@PostMapping("/user/changePassAction")
	public String updatePassword(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "password1", required = true) String password1,
			@RequestParam(value = "password2", required = true) String password2) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		if (password1 == null || password2 == null || password1.equals("") || password1.equals("")) {
			map.addAttribute("errorMessage", "Error , Incomplete password submitted.");
			return "userChangePassword";
		}
		if (!password1.equals(password2)) {
			map.addAttribute("errorMessage", "Error , Password do not match.");
			return "userChangePassword";
		}

		User user = userService.findById((long) session.getAttribute("user_id"));

		user.setPassword(password1);
		userService.updatePassword(user);

		return "redirect:/user/ChangePassConfirm";
	}

	@GetMapping("/user/ChangePassConfirm")
	public String changepassConfirm(ModelMap map, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		return "userChangePassConfirm";
	}

	@GetMapping("/user/registerConfirm")
	public String registerConfirm(ModelMap map) {
		return "userRegisterConfirm";
	}

}
