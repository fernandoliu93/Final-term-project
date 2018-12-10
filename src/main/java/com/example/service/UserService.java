package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserMapper;
import com.example.entity.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public List<User> getAll() {
		return userMapper.getUserList();
	}

	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}
	
	public int getIdByName(String name) {
		return userMapper.getIdByName(name);
	}

	public void creat(String name, String password) {
		userMapper.creat(name, password);
	}
}