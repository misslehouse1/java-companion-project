package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.ReviewImpl;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(ReviewImpl reviewImpl, ModelMap model) {
		if(reviewImpl.getAuthor().equals("")) {
			reviewImpl.setAuthor("anonymous");
		}
		return new ModelAndView("reviewDetailPage", "submittedReview", reviewImpl);
	}

	
	@RequestMapping(value = "/gameLibrary", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("gamesPage", "command", new GameImpl());
	}
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}
/*
	@RequestMapping(value = "/games", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl gameImpl) {
		gameService.saveGame(gameImpl);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	*/
	@PostMapping(value="/games", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl gameImpl) {
		gameService.saveGame(gameImpl);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/games", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody GameImpl gameImpl) {
		gameService.saveGame(gameImpl);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/games")
	public ResponseEntity<?> deleteGame(@RequestBody GameImpl gameImpl){
		return new ResponseEntity<>(gameService.deleteGame(gameImpl), HttpStatus.OK);
	}
	
	
}