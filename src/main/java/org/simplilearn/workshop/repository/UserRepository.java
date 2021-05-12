package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
	
	@Query("Select u from User u where u.authorizationStatus=0")
	List<User> list();
	
	@Modifying
	@Transactional
	@Query("delete from User u where u.username=?1")
	void rejectAuthorization(String username);

}
