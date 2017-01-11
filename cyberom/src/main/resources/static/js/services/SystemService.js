/**
 * 
 */
module.factory('SystemService', ['$http','$q','FilterAndPaginationUtils', 'RequestUtils',
                                 function($http, $q, FilterAndPaginationUtils, RequestUtils){
	
	var factory = {};
	
	factory.getSystems = function(systemSearchFilter) {
		var queryString = 
			FilterAndPaginationUtils.buildQueryString(systemSearchFilter);
		var url = "rest/systems" + queryString;
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.getSystem = function(cybercafeId, systemId) {
		
	};
	
	factory.addSystem = function(system) {
		var url = "rest/systems";
		return RequestUtils.sendPostRequest(url, system);
	}
	
	return factory;
	
}]);