package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;


@Repository
@Mapper
public interface AdminMapper {

	@Select("SELECT * FROM admin WHERE name=#{name}")
	Admin getAdminByName(String name);
	
}
