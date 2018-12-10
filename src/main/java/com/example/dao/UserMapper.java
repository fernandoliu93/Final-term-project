package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")
	List<User> getUserList();

	@Select("SELECT * FROM user WHERE name=#{name}")
	User getUserByName(String name);
	
	@Select("SELECT id FROM user WHERE name=#{name}")
	int getIdByName(String name);

	@Insert("INSERT INTO user(name,password) values (#{name},#{password})")
	void creat(@Param("name") String name, @Param("password") String password);

	@Update("UPDATE user SET state='unusable' WHERE id=#{userid}")
	void block(int userid);

	@Update("UPDATE user SET state='usable' WHERE id=#{userid}")
	void open(int userid);
}
