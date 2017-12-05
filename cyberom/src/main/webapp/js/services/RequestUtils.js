/**
 * 
 */
module.factory('RequestUtils',['$q', '$http', function($q, $http){
	var factory = {};
	
	factory.sendGetRequest = function(url) {
		var deferred = $q.defer();
		$http.get(url)
			.success(function(data){
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg);
			});
		return deferred.promise;
	};
	
	factory.sendPostRequest = function(url, dataToPost){
		var deferred = $q.defer();
		$http.post(url, dataToPost)
			.success(function(data) {
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg)
			});
		return deferred.promise;
	};
	
	factory.sendPutRequest = function(url, dataToPut){
		var deferred = $q.defer();
		$http.put(url, dataToPut)
			.success(function(data) {
				deferred.resolve(data);
			})
			.error(function(msg, code){
				deferred.reject(msg)
			});
		return deferred.promise;
	};
	
	return factory;
}]);