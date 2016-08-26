/**
 * 
 */

module.factory('VisitorService', ['$q', '$http', function($q, $http){
	
	var factory = {};
	
	factory.save = function(visitor) {
		var deferred = $q.defer();
		$http.post("rest/visitors", visitor)
		.success(function(data) {
			deferred.resolve(data);
		})
		.error(function(msg, code){
			deferred.reject(msg)
		});
		return deferred.promise;
	};
	
	factory.getVisitors = function(visitorSearchFilter) {
		var deferred = $q.defer();
		var url = "rest/visitors" + buildQueryString(visitorSearchFilter);
		
		$http.get(url)
		.success(function(data){
			deferred.resolve(data)
		})
		.error(function(msg, code){
			deferred.reject(msg)
		});
		return deferred.promise;
	};
	
	function buildQueryString(filters) {
		var queryString = "?";
		for(var i=0; i<filters.length;i++) {
			var filter = filters[i];
			if(i > 0) {
				queryString += "&";
			}
			queryString += filter.name + "=" + filter.value;
		}
		return queryString;
	}
	
	factory.getVisitor = function(visitorId) {
		var deferred = $q.defer();
		$http.get("rest/visitors/"+visitorId)
		.success(function(data){
			deferred.resolve(data)
		})
		.error(function(msg, code){
			deferred.reject(msg)
		});
		return deferred.promise;
	};
	
	factory.edit = function(visitor) {
		var deferred = $q.defer();
		$http.put("rest/visitors", visitor)
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