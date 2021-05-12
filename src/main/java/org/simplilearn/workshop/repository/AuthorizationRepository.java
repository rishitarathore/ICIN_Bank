package org.simplilearn.workshop.repository;

import org.simplilearn.workshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorizationRepository extends JpaRepository<User, Long>{
	
	@Modifying
	@Transactional
	@Query("update User u set u.authorizationStatus=1 where u.username=?1")
	void authorizeUser(String username);

	@Modifying
	@Transactional
	@Query("update User u set u.status=1 where u.username=?1")
	void userStatusActivate(String username);

	@Modifying
	@Transactional
	@Query("update User u set u.status=0 where u.username=?1")
	void userStatusBlock(String username);
	

	@Modifying
	@Transactional
	@Query("update User u set u.featureStatus=?2 where u.username=?1")
	void grantAccess(String username, int featureStatus);
}
