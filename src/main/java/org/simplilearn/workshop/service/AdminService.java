package org.simplilearn.workshop.service;

import org.simplilearn.workshop.model.Admin;
import org.simplilearn.workshop.repository.AdminRepository;
import org.simplilearn.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
    }

	public Admin findByUsernameAndPassword(String username, String password) {
		 return adminRepository.findByUsernameAndPassword(username, password);
	}

	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	public void save(Admin admin) {
		adminRepository.save(admin);
		
	}
}
