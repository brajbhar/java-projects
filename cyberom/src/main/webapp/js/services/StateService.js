/**
 * 
 */
module.factory('StateService', ['$http','$q', 'RequestUtils',
                                function($http, $q, RequestUtils){
	
	var factory = {};
	
	factory.getStates = function(){
		var url = "rest/states";
		return RequestUtils.sendGetRequest(url);
	};

	factory.getCitiesByState = function(stateId){
		var url = "rest/cities?stateId="+stateId;
		return RequestUtils.sendGetRequest(url);	
	};

	return factory;
}]);