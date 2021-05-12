package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.ChequeBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransactionRepository extends JpaRepository<ChequeBookRequest, Long> {
	
	@Query("Select c from ChequeBookRequest c where c.requestStatus=0")
	public List<ChequeBookRequest> list();
	
	@Modifying
	@Transactional
	@Query("update ChequeBookRequest c set c.requestStatus=1 where c.requestId = ?1")
	void setChequebookInfoByAccount(long accNo);
	
	public ChequeBookRequest findByRequestId(long request_id);
}
