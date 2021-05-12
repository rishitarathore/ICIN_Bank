package org.simplilearn.workshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.commons.mail.EmailException;
import org.simplilearn.workshop.model.ChequeBookRequest;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.service.AuthorizationService;
import org.simplilearn.workshop.service.MailService;
import org.simplilearn.workshop.service.TransactionService;
import org.simplilearn.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

	private UserService userService;
	private AuthorizationService authorizationService;
	private MailService mailService;
	private TransactionService transactionService;

	@Autowired
	public AuthorizationController(UserService userService, AuthorizationService authorizationService,
			MailService mailService, TransactionService transactionService) {
		this.userService = userService;
		this.authorizationService = authorizationService;
		this.mailService = mailService;
		this.transactionService = transactionService;
	}

	@GetMapping("/admin/authorize")
	public String authorize(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		List<User> list = userService.list();
		map.addAttribute("list", list);
		return "adminAuthorize";
	}

	@GetMapping("/admin/authorizationAccept")
	public String authorizationAccept(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		} else {
			try {
				authorizationService.authorizeUser(username);
				mailService.sendAcceptEmail(username);
			} catch (EmailException e) {
				e.printStackTrace();
			}
			return "redirect:/admin/authorize";
		}
	}

	@GetMapping("/admin/authorizationReject")
	public String authorizationReject(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		} else {
			try {
				mailService.sendRejectEmail(username);
				authorizationService.rejectAuthorization(username);
			} catch (EmailException e) {
				e.printStackTrace();
			}
			return "redirect:/admin/authorize";
		}
	}

	@GetMapping("/admin/authorizeChequeBook")
	public String authorizeChequebook(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		List<ChequeBookRequest> list = transactionService.list();
		map.addAttribute("list", list);
		return "adminAuthorizeChequeBook";
	}

	@GetMapping("/admin/authorizeChequeBookAction")
	public String authroizeChequeBookAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "requestId", required = true) Long request_id) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		authorizationService.acceptChequeBookRequest(request_id);
		return "redirect:/admin/authorizeChequeBook";
	}

	@GetMapping("/admin/activateUser")
	public String activateUser(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		authorizationService.activate(username);
		return "redirect:/admin/userAccountInfo";
	}

	@GetMapping("/admin/blockUser")
	public String blockUser(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}
		authorizationService.block(username);
		return "redirect:/admin/userAccountInfo";
	}

	@GetMapping("/admin/grantAccess")
	public String grantAccess(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "featureSelect", required = true) int featureStatus) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
			return "adminLogin";
		}

		else {
			authorizationService.grantAccess(username, featureStatus);
			return "redirect:/admin/userAccountInfo";
		}
	}
}
