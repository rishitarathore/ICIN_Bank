package org.simplilearn.workshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.TransactionHistory;
import org.simplilearn.workshop.model.TransferHistory;
import org.simplilearn.workshop.service.AccountService;
import org.simplilearn.workshop.service.TransactionHistoryService;
import org.simplilearn.workshop.service.TransferHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {
	
	private TransactionHistoryService transactionHistoryService;
	private TransferHistoryService transferHistoryService;
	private AccountService accountService;
	
	public HistoryController(TransactionHistoryService transactionHistoryService, TransferHistoryService transferHistoryService,
			 AccountService accountService) {
		this.transactionHistoryService = transactionHistoryService;
		this.transferHistoryService = transferHistoryService;
		this.accountService = accountService;
	}
	   
	@GetMapping("/user/transactionHistory")
	public String transactionHistory(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		long userId = (Long) session.getAttribute("user_id");
		List<TransactionHistory> list = transactionHistoryService.findAllByUserId(userId);
		map.addAttribute("list", list);
		Account account = accountService.findByUsername((String)session.getAttribute("user_username"));
		map.addAttribute("account",account);
		return "userTransactionHistory";
	}
	
	@GetMapping("/user/transferHistory")
	public String transferHisory(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		long userId = (Long) session.getAttribute("user_id");
		List<TransferHistory> list = transferHistoryService.findAllByUserId(userId);
		map.addAttribute("list", list);
		Account account = accountService.findByUsername((String)session.getAttribute("user_username"));
		map.addAttribute("account",account);
		return "userTransferHistory";
	}
	
	


}
