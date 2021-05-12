package org.simplilearn.workshop.service;

import org.apache.commons.mail.EmailException;
import org.simplilearn.workshop.model.ChequeBookRequest;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.repository.AuthorizationRepository;
import org.simplilearn.workshop.repository.TransactionRepository;
import org.simplilearn.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

	private AuthorizationRepository authorizationRepository;
	private UserService userService;
	private AccountService accountService;
	private TransactionRepository transactionRepository;
	private MailService mailService;
	private UserRepository userRepository;
	private TransactionService transactionService;

	@Autowired
	public AuthorizationService(AuthorizationRepository authorizationRepository, UserService userService,
			AccountService accountService, TransactionRepository transactionRepository, MailService mailService,
			UserRepository userRepository, TransactionService transactionService) {
		this.authorizationRepository = authorizationRepository;
		this.userService = userService;
		this.accountService = accountService;
		this.transactionRepository = transactionRepository;
		this.mailService = mailService;
		this.userRepository = userRepository;
		this.transactionService = transactionService;
	}

	public void authorizeUser(String username) {
		authorizationRepository.authorizeUser(username);
		authorizationRepository.userStatusActivate(username);

		User currUser = userService.findByUsername(username);
		long userId = currUser.getId();

		accountService.newAccount(username, userId);
	}

	public void rejectAuthorization(String username) {
		userRepository.rejectAuthorization(username);
	}

	public void acceptChequeBookRequest(long request_id) {
		ChequeBookRequest cbr = transactionService.findByRequestId(request_id);
		Long accno = cbr.getAccno();
		transactionRepository.setChequebookInfoByAccount(request_id);
		String username = accountService.findByAccNo(accno).getUsername();
		try {
			mailService.sendChequeBookConfirmationEmail(username);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public void activate(String username) {
		authorizationRepository.userStatusActivate(username);
	}

	public void block(String username) {
		authorizationRepository.userStatusBlock(username);
	}

	public void grantAccess(String username, int featureStatus) {
		authorizationRepository.grantAccess(username, featureStatus);
	}

}
