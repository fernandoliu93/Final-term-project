package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.entity.Favorite;
import com.example.entity.Game;
import com.example.entity.Team;
import com.example.entity.pGame;

@Repository
@Mapper
public interface TeamMapper {

	@Select("SELECT * FROM teams")
	List<Team> getTeamList();

	@Select("SELECT * FROM teams WHERE location='west'")
	List<Team> getWestTeamList();
	
	@Select("SELECT * FROM teams WHERE location='east'")
	List<Team> getEastTeamList();
	
	@Select("SELECT * FROM teams WHERE location='west' ORDER BY win DESC")
	List<Team> getWestTeamListOrder();
	
	@Select("SELECT * FROM teams WHERE location='east' ORDER BY win DESC")
	List<Team> getEastTeamListOrder();

	@Select("SELECT * FROM teams WHERE name=#{name}")
	Team getTeamByName(String name);
	
	@Select("SELECT * FROM schedules WHERE host=#{name} OR guest=#{name}")
	List<Game> getSchedulesGameByTeam(String name);
	
	@Select("SELECT * FROM previous WHERE host=#{name} OR guest=#{name}")
	List<pGame> getPreviousGameByTeam(String name);
	
	@Select("SELECT * FROM previous WHERE time like CONCAT(CONCAT('%', #{date}), '%')")
	List<pGame> getTodayGameByTeam(String date);

	@Insert("INSERT INTO favorite(userId,teamName) values (#{userId},#{teamName})")
	void like(@Param("teamName") String teamName,@Param("userId") int userId);
	
	@Delete("DELETE FROM favorite WHERE userId=#{userId} AND teamName=#{teamName}")
	void dislike(@Param("teamName")String teamName, @Param("userId")int userId);
	
	@Select("SELECT * FROM favorite WHERE userId=#{userId}")
	List<Favorite> getFavoriteTeam(int userId);

	@Select("SELECT * FROM favorite WHERE userId=#{userId} AND teamName=#{teamName}")
	List<Favorite> judgeLike(@Param("userId")int id, @Param("teamName")String team_name);
}
