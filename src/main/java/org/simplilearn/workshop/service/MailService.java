package org.simplilearn.workshop.service;

import org.simplilearn.workshop.model.Account;

import org.simplilearn.workshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.DefaultAuthenticator;

@Service
public class MailService {

	private AccountService accountService;
	private UserService userService;

	@Autowired
	public MailService(UserService userService, AccountService accountService) {
		this.accountService = accountService;
		this.userService = userService;
	}

	@SuppressWarnings("deprecation")
	public void sendAcceptEmail(String username) throws EmailException {

		User user = userService.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFirstname() + " " + user.getLastname();
		Account account = accountService.findByUsername(username);
		long accountNo = account.getAccno();
		long balance = account.getBalance();

		HtmlEmail mail = new HtmlEmail();
		mail.setSSL(true);
		mail.setHostName("smtp.gmail.com");
		mail.setSmtpPort(465);
		mail.setAuthenticator(new DefaultAuthenticator("icin.noreply@gmail.com", "temppass@icin321"));

		mail.setFrom("icin.noreply@gmail.com", "ICIN Bank");
		mail.addTo(receiver, "To");
		mail.setSubject(user.getFirstname() + ", Welcome to your new ICIN Bank Account");
		mail.setHtmlMsg("<h1 style='font-size:27px;color:blue'>Hi " + fullName + ",</h1>"
				+ "<br><h2 style='font-size:21px;color:black'>Thank you for creating a ICIN Bank account. Your account has been activated,"
				+ " Here are your details.</h2><br>" + "<p style='font-size:18px;'>Username: " + username
				+ "<br><p style='font-size:18px;'>Account Number: " + accountNo + "<br>"
				+ "<p style='font-size:18px;'>Current Balance: Rs. " + balance + "</p>");
		mail.send();
	}

	@SuppressWarnings("deprecation")
	public void sendRejectEmail(String username) throws EmailException {

		User user = userService.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFirstname() + " " + user.getLastname();

		HtmlEmail mail = new HtmlEmail();
		mail.setSSL(true);
		mail.setHostName("smtp.gmail.com");
		mail.setSmtpPort(465);
		mail.setAuthenticator(new DefaultAuthenticator("icin.noreply@gmail.com", "temppass@icin321"));

		mail.setFrom("icin.noreply@gmail.com", "ICIN Bank");
		mail.addTo(receiver, "To");
		mail.setSubject("ICIN Bank Account Cancelled");
		mail.setHtmlMsg("<h1 style='font-size:27px;color:red'>Hi " + fullName + ",</h1>"
				+ "<br><p style='font-size:19px;color:black'>Sorry, Your account with ICIN Bank with username "
				+ username + " has been cancelled. Please contact nearest branch for more details.</p><br><br>");
		mail.send();
	}

	@SuppressWarnings("deprecation")
	public void sendChequeBookConfirmationEmail(String username) throws EmailException {

		User user = userService.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFirstname() + " " + user.getLastname();

		HtmlEmail mail = new HtmlEmail();
		mail.setSSL(true);
		mail.setHostName("smtp.gmail.com");
		mail.setSmtpPort(465);
		mail.setAuthenticator(new DefaultAuthenticator("icin.noreply@gmail.com", "temppass@icin321"));
		mail.setFrom("icin.noreply@gmail.com", "ICIN Bank");
		mail.addTo(receiver, "To");
		mail.setSubject("ICIN Bank Chequebook Request Confirmed");
		mail.setHtmlMsg("<h1 style='font-size:25px;color:green'>Hi " + fullName + ",</h1>"
				+ "<br><p style='font-size:19px;color:black'>Your chequebook request has been processed and confirmed it will be sent to you via courier in 4-5 business days.</p><br><br>");
		mail.send();
	}

}
