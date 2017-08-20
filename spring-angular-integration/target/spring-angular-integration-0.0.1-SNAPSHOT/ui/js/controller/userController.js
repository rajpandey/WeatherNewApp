'use strict';
App.controller('userController', ['$scope', '$rootScope', 'userService', '$http',
		function($scope, $rootScope, userService, $http) {

			$scope.user = {};
			$scope.user.email = "";
			$scope.user.password = "";
			$scope.showUserDetails = false;
			$scope.showLogin = true;
			$scope.userDetails = [];

			$scope.login = function() {
				userService.postUserData($scope.user).then(
						function(d) {
							$scope.showLogin = false;
							$scope.showUserDetails = true;
							$scope.getUserDetails();
						});
			};
			
			$scope.getUserDetails = function() {
				userService.getUserDetails().then(
						function(d) {
							$scope.userDetails = d;
						});
			}

		} ]);