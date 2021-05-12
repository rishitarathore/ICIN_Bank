package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccno(long accno);

	public Account findByUsername(String username);
	
	public List<Account> findAll(); 
}
