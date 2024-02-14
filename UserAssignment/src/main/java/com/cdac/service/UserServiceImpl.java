package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.model.User;
import com.cdac.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User login(User user) {
		try {
			User u = userRepo.login(user.getEmail(),user.getPassword());
			if(u != null) {
				if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
					return u;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean register(User user) {
		try {
			Optional<User> opt = userRepo.findById(user.getUserId());
			
			if(opt.isPresent())
				return false;
			else {
				userRepo.save(user);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
