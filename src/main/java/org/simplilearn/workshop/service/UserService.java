package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public void saveUser(User user) {
		userRepository.save(user);			
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public List<User> list() {
		return userRepository.list();
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	 public void updatePassword(User user) {
		 userRepository.save(user);
	}

	 public User findById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }

}
