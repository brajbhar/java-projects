/**
 * 
 */
module.factory('SystemService', ['$http','$q','FilterAndPaginationUtils',
                                 function($http, $q, FilterAndPaginationUtils){
	
	var factory = {};
	
	factory.getSystems = function(systemSearchFilter) {
		var queryString = 
			FilterAndPaginationUtils.buildQueryStrin(systemSearchFilter);
		var url = "rest/systems" + queryString;
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.getSystem = function(cybercafeId, systemId) {
		
	};
	
	return factory;
	
}]);