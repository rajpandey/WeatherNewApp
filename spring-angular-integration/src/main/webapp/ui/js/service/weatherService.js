'use strict';

App.factory('weatherService', function($http, $q) {
    return {

    	getWeatherDetails : function(inputJson) {
        	return $http.post('getWeatherDetails',inputJson)
            .then(
                function(response){
                    return response.data;
                },
                function(errResponse) {
                    alert(errResponse.status + ':' + errResponse.statusText);
                    return $q.reject(errResponse);
                });
        }
    };
});