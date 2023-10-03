package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class GameMockDAOImpl implements GameDAO{
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> gameImpls = new ArrayList<>();

	static {
		gameImpls = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		gameImpls.add(game1);
		gameImpls.add(game2);
		gameImpls.add(game3);

		return gameImpls;
	}

	@Override
	public List<Game> retrieveAllGames() {
		return ImmutableList.copyOf(gameImpls);
	}

	@Override
	public Game saveGame(Game game) {
		if(game.getId() != null) {
			Game foundGame = findGameById(game.getId());
			if(foundGame != null) {
				for(int i = 0; i < gameImpls.size(); i++) {
					if(game.getId().equals(gameImpls.get(i).getId())) {
						gameImpls.set(i, (GameImpl)game);
					}
				}
				return game;
			}
		}
		game.setId(++gameId);
		gameImpls.add((GameImpl)game);
		return game;
		
	}

	@Override
	public boolean deleteGame(Game game) {
		
		for (int i = 0; i < gameImpls.size(); i++) {
			if(game.getId() == (gameImpls.get(i).getId())) {
				gameImpls.remove(gameImpls.get(i));
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Game findGameById(Long id) {
		for(GameImpl gameImpl : gameImpls) {
			if(id.equals(gameImpl.getId())) {
				return gameImpl;
			}
		}
		return null;
	}
}
