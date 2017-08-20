'use strict';
App.controller('weatherController', ['$scope', '$rootScope', '$http','weatherService',
		function($scope, $rootScope, $http,weatherService) {

	$scope.data = {
		    model: null,
		    availableOptions: [
		      {id: '1', name: 'Sydney'},
		      {id: '2', name: 'Melbourne'},
		      {id: '3', name: 'Wollongong'}
		    ]
		   };
	$scope.weatherDetails=[];
	$scope.isWeatheDeat=false;
	$scope.$watch('data', function() {
		
	if($scope.data.model!=null)
	{
		weatherService.getWeatherDetails($scope.data.model).then(
				function(d) {
					$scope.weatherDetails = d;
					if($scope.weatherDetails!=null || $scope.weatherDetails!=undefined)
					{
						$scope.isWeatheDeat=true;
					}	
					
				});	
	}
    }, true);
	

		} ]);