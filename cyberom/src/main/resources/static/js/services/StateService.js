/**
 * 
 */
module.factory('StateService', ['$http','$q', function($http, $q){
	
	var factory = {};
	
	factory.getStates = function(){
		var deferred = $q.defer();
		$http.get("rest/states")
			.success(function(data){
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg);
			});
		return deferred.promise;
	},

	factory.getCitiesByState = function(stateId){
		var deferred = $q.defer();
		$http.get("rest/cities?stateId="+stateId)
			.success(function(data) {
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg);
			});
		return deferred.promise;	
	}

	return factory;
}]);