'use strict';

angular.module('MGL_Task1_app').factory('GameService', ['$http', function($http) {

		var REST_SERVICE_URI = '/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			updateGame : updateGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'games').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'games', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGame(game) {
			return $http.put(REST_SERVICE_URI + 'games', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(game) {
			return $http.put(REST_SERVICE_URI + 'games', game).then(function(response) {
					return response.data;
				}
			);
		}
		

}]);
