package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameMockDAOImpl;
import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;
	
	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game gameImpl) {
		//initially saving logic
		
		return gameDAO.saveGame(gameImpl);
	}
	
	@Override
	public Game updateGame(Game gameImpl) {
		//update business logic
		return gameDAO.saveGame(gameImpl);
	}
	
	@Override
	public boolean deleteGame(Game gameImpl) {
		return gameDAO.deleteGame(gameImpl);
	}
	
	@Override
	public Game findGameById(Long id) {
		return gameDAO.findGameById(id);
	}
	
	

}