'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.game = {};
				self.fetchAllGames();
				});
			}
			
			self.selectGame = function(game){
				self.game = angular.copy(game);
			}
			
			self.deleteGame = function(game){
				return GameService.deleteGame(game).then(function(){
					self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
