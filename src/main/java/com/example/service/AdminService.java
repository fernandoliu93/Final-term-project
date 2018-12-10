package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminMapper;
import com.example.dao.UserMapper;
import com.example.entity.Admin;


@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	UserMapper userMapper;
	public Admin getAdminByName(String name) {
		return adminMapper.getAdminByName(name);
	}
	public void block(int userid) {
		userMapper.block(userid);
	}
	public void open(int userid) {
		userMapper.open(userid);
	}

}