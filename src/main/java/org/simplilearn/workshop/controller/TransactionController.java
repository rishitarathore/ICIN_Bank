package org.simplilearn.workshop.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;
import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.ChequeBookRequest;
import org.simplilearn.workshop.model.TransactionHistory;
import org.simplilearn.workshop.model.TransferHistory;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.service.AccountService;
import org.simplilearn.workshop.service.TransactionHistoryService;
import org.simplilearn.workshop.service.TransactionService;
import org.simplilearn.workshop.service.TransferHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
	private TransactionService transactionService;
	private AccountService accountService;
	private TransactionHistoryService transactionHistoryService;
	private TransferHistoryService transferHistoryService;

	public TransactionController(TransactionService transactionService, AccountService accountService,
			TransactionHistoryService transactionHistoryService, TransferHistoryService transferHistoryService) {
		this.transactionService = transactionService;
		this.accountService = accountService;
		this.transactionHistoryService = transactionHistoryService;
		this.transferHistoryService = transferHistoryService;
	}

	@GetMapping("/user/deposit")
	public String deposit(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userDeposit";
		}
	}

	@GetMapping("/user/depositConfirm")
	public String depositConfirm(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userDepositConfirm";
		}
	}

	@GetMapping("/user/withdraw")
	public String withdraw(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userWithdraw";
		}
	}

	@GetMapping("/user/withdrawConfirm")
	public String withdrawConfirm(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userWithdrawConfirm";
		}
	}

	@GetMapping("/user/requestChequeBook")
	public String requestChequeBook(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userRequestChequeBook";
		}
	}

	@GetMapping("/user/requestChequeBookConfirm")
	public String requestChequeBookConfirm(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userRequestChequeBookConfirm";
		}
	}

	@GetMapping("/user/transferMoney")
	public String transferMoney(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		} else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userTransferMoney";
		}
	}

	@GetMapping("/user/transferMoneyConfirm")
	public String transferMoneyConfirm(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userTransferMoneyConfirm";
		}
	}

	@GetMapping("/user/transferMoneyDecline")
	public String transferMoneyDecline(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		// check if session is still alive
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		else {
			Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
			map.addAttribute("account", account);
			return "userTransferMoneyDecline";
		}
	}

	@PostMapping("/user/depositAction")
	public String depositAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "amount", required = true) Long amount) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
		User user = account.getUser();

		if (amount < 1) {
			map.addAttribute("account", account);
			map.addAttribute("errorMessage", "Invalid Amount");
			return "userDeposit";
		}

		else {

			long balance = account.getBalance();
			balance += amount;
			account.setBalance(balance);
			transactionService.save(account);
			TransactionHistory t = new TransactionHistory();
			t.setAction("Deposit");
			t.setAmount(amount);
			t.setDateTime(LocalDateTime.now());
			t.setUser(user);
			transactionHistoryService.save(t);

			// store transaction object and account object in session to use it in confirm
			// page
			session.setAttribute("transaction_session", t);
			session.setAttribute("account_session", account);

			return "redirect:/user/depositConfirm";
		}
	}

	@PostMapping("/user/withdrawAction")
	public String withdrawAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "amount", required = true) Long amount) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
		User user = account.getUser();
		long balance = account.getBalance();
		if (amount > balance) {
			// for sub nav user info
			map.addAttribute("account", account);
			map.addAttribute("errorMessage", "Insufficient Balance");
			return "userWithdraw";
		}

		else if (amount < 1) {
			map.addAttribute("account", account);
			map.addAttribute("errorMessage", "Invalid Amount");
			return "userWithdraw";
		}

		else {
			balance -= amount;
			account.setBalance(balance);
			accountService.save(account);
			TransactionHistory t = new TransactionHistory();
			t.setAction("Withdraw");
			t.setAmount(amount);
			t.setUser(user);
			t.setDateTime(LocalDateTime.now());
			transactionHistoryService.save(t);
			// store transaction object and account object in session to use it in confirm
			// page
			session.setAttribute("transaction_session", t);
			session.setAttribute("account_session", account);
			return "redirect:/user/withdrawConfirm";
		}

	}

	@PostMapping("/user/transferAction")
	public String transferAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "accno", required = true) Long accno,
			@RequestParam(value = "amount", required = true) Long amount) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}

		Account senderAccount = accountService.findByUsername((String) session.getAttribute("user_username"));
		User user = senderAccount.getUser();
		Account benificiaryAccount = accountService.findByAccNo(accno);
		long bal = senderAccount.getBalance();
		TransferHistory t = new TransferHistory();

		// validate for insufficient
		if (amount > bal) {
			// for sub nav user info
			map.addAttribute("account", senderAccount);

			map.addAttribute("errorMessage", "Insufficient Balance");
			return "userTransferMoney";
		}
		else if (amount < 1) {
			map.addAttribute("account", senderAccount);
			map.addAttribute("errorMessage", "Invalid Amount");
			return "userTransferMoney";
		}
		// condition to stop transfer to self account.
		else if (accno == senderAccount.getAccno()) {
			// for sub nav user info
			map.addAttribute("account", senderAccount);

			map.addAttribute("errorMessage", "Cannot Transfer to self account");
			return "userTransferMoney";
		}
		// condition for beneficiary account not found
		else if (benificiaryAccount == null) {
			t.setAmount(amount);
			t.setDateTime(LocalDateTime.now());
			t.setSenderAccount(senderAccount.getAccno());
			t.setRecipientAccount(accno);
			t.setUser(user);
			t.setStatus("Failed");
			transferHistoryService.save(t);
			// store transfer object in session to use it in confirm page
			// here only transfer id is needed so only setting transfer_session
			session.setAttribute("transfer_session", t);
			return "redirect:/user/transferMoneyDecline";
		}

		else {
			bal -= amount;
			senderAccount.setBalance(bal);
			accountService.save(senderAccount);

			long balance = benificiaryAccount.getBalance();
			balance += amount;
			benificiaryAccount.setBalance(balance);
			accountService.save(benificiaryAccount);
			t.setAmount(amount);
			t.setDateTime(LocalDateTime.now());
			t.setRecipientAccount(benificiaryAccount.getAccno());
			t.setStatus("Success");
			t.setUser(user);
			t.setSenderAccount(senderAccount.getAccno());
			transferHistoryService.save(t);

			// code for storing transfer details in transaction history of both sender and
			// recievers

			// sender
			TransactionHistory senderTransactionHistory = new TransactionHistory();
			senderTransactionHistory.setAction("Transferred To " + benificiaryAccount.getUser().getFirstname() + " "
					+ benificiaryAccount.getUser().getLastname() + " (A/c No. " + benificiaryAccount.getAccno() + ")");
			senderTransactionHistory.setDateTime(LocalDateTime.now());
			senderTransactionHistory.setAmount(amount);
			senderTransactionHistory.setUser(senderAccount.getUser());
			transactionHistoryService.save(senderTransactionHistory);

			// reciever
			TransactionHistory beneficiaryTransactionHistory = new TransactionHistory();
			beneficiaryTransactionHistory.setAction("Recieved From " + senderAccount.getUser().getFirstname() + " "
					+ senderAccount.getUser().getLastname() + " (A/c No. " + senderAccount.getAccno() + ")");
			beneficiaryTransactionHistory.setDateTime(LocalDateTime.now());
			beneficiaryTransactionHistory.setAmount(amount);
			beneficiaryTransactionHistory.setUser(benificiaryAccount.getUser());
			transactionHistoryService.save(beneficiaryTransactionHistory);

			// store transfer object in session to use it in confirm page
			// here only transfer id is needed so only setting transfer_session
			session.setAttribute("transfer_session", t);
			session.setAttribute("account_session", senderAccount);
			return "redirect:/user/transferMoneyConfirm";
		}
	}

	@PostMapping("/user/requestChequeBookAction")
	public String requestChequeBookAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "no_of_pages", required = true) int no_of_pages) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "userLogin";
		}
		Account account = accountService.findByUsername((String) session.getAttribute("user_username"));
		ChequeBookRequest cbr = new ChequeBookRequest();
		cbr.setAccno(account.getAccno());
		cbr.setNo_of_pages(no_of_pages);
		cbr.setDateTime(LocalDateTime.now());
		transactionService.saveReqChequeBook(cbr);
		// store cheque request object to fetch txn number in front end
		session.setAttribute("cheque_session", cbr);
		return "redirect:/user/requestChequeBookConfirm";
	}

}
