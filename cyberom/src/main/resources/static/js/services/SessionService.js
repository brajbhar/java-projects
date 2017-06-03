/**
 * 
 */

module.factory('SessionService', ['$http','$q','FilterAndPaginationUtils', 'RequestUtils',
                                 function($http, $q, FilterAndPaginationUtils, RequestUtils){
	
	var factory = {};
	
	factory.getSessions = function(sessionSearchFilter) {
		var queryString = 
			FilterAndPaginationUtils.buildQueryString(sessionSearchFilter);
		var url = "rest/sessions" + queryString;
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.getSystem = function(systemId) {
		var url = "rest/systems/" + systemId;
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.addSession = function(session) {
		var url = "rest/sessions";
		return RequestUtils.sendPostRequest(url, session);
	};
	
	factory.editSystem = function(system) {
		var url = "rest/systems";
		return RequestUtils.senPutRequest(url, system);
	};
	
	
	return factory;
	
}]);