package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TeamMapper;
import com.example.dao.UserMapper;
import com.example.entity.Favorite;
import com.example.entity.Game;
import com.example.entity.Team;
import com.example.entity.User;
import com.example.entity.pGame;

@Service
public class TeamService {

	@Autowired
	TeamMapper teamMapper;
	
	@Autowired
	UserService userService;

	public List<Team> getAll() {
		return teamMapper.getTeamList();
	}
	
	public List<Team> getEastTeamListOrder() {
		return teamMapper.getEastTeamListOrder();
	}
	
	public List<Team> getWestTeamListOrder() {
		return teamMapper.getWestTeamListOrder();
	}

	public Team getTeamByName(String name) {
		return teamMapper.getTeamByName(name);
	}
	
	public List<Game> getSchedulesGameByTeam(String name) {
		return teamMapper.getSchedulesGameByTeam(name);
	}
	
	public List<pGame> getPreviousGameByTeam(String name) {
		return teamMapper.getPreviousGameByTeam(name);
	}

	public void like(String teamName, String userName) {
		User temp = userService.getUserByName(userName);
		teamMapper.like(teamName,temp.getId());
		
	}
	
	public void dislike(String teamName, String userName) {
		User temp = userService.getUserByName(userName);
		teamMapper.dislike(teamName,temp.getId());	
	}
	
	public List<Favorite> getFavoriteTeam(int userId) {
		List<Favorite> favorites = teamMapper.getFavoriteTeam(userId);
		
		return favorites;
	}

	public List<pGame> getTodayGames(String date) {
		return teamMapper.getTodayGameByTeam(date);
	}

	public int judgeLike(int id, String team_name) {
		List<Favorite> favorites = teamMapper.judgeLike(id,team_name);
		if (favorites.size()>0) {
			return 1;
		}else{
			return 0;
		}
	}


}