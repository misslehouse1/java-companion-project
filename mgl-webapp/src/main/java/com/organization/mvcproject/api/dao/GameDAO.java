package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameDAO {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

	boolean deleteGame(Game game);
	
	Game findGameById(Long id);

}
