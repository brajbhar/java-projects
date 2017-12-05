/**
 * 
 */
module.factory('CybercafeService', ['$http', '$q', function($http, $q){
	
	var factory = {};
	
	factory.getCybercafeById = function(cybercafeId) {
		var deferred = $q.defer();
		$http.get("rest/cybercafes/"+cybercafeId)
			.success(function(data){
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg);
			});
		return deferred.promise;
	};
	
	factory.getIDCardTypes = function() {
		var deferred = $q.defer();
		$http.get("rest/idcardtypes/")
			.success(function(data){
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg);
			});
		return deferred.promise;
	};
	
	return factory;
}]);