package com.cdac.service;

import com.cdac.model.User;

public interface UserService {

	public User login(User user);
	public boolean register(User user);
}
