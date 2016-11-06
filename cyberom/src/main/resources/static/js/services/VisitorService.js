/**
 * 
 */

module.factory('VisitorService', ['$q', '$http', 'FilterAndPaginationUtils', 
                                  'RequestUtils',
                                  function($q, $http, FilterAndPaginationUtils, 
                                		  RequestUtils){
	
	var factory = {};
	
	factory.save = function(visitor) {
		var url = "rest/visitors";
		return RequestUtils.sendPostRequest(url, visitor);
	};
	
	factory.getVisitors = function(visitorSearchFilter) {
		var url = "rest/visitors" + 
			FilterAndPaginationUtils.buildQueryString(visitorSearchFilter);
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.getVisitor = function(visitorId) {
		var url = "rest/visitors/"+visitorId;
		return RequestUtils.sendGetRequest(url);
	};
	
	factory.edit = function(visitor) {
		var url = "rest/visitors";
		return RequestUtils.sendPutRequest(url, visitor);
	};
	
	return factory;
	
}]);