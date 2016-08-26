/**
 * 
 */

module.controller("NavigationController", ['$location', '$rootScope', '$scope','$http',
                                      function($location, $rootScope, $scope, $http) {
	
	$scope.credentials = {};
	$scope.error = {};
	
	var authenticate = function(credentials, callback){
		  var headers = credentials ? {authorization: "Basic " + 
			  		btoa(credentials.username + ":" +credentials.password)}:{};
		  $http.get('user', {headers : headers}).then(function(response){
			  if(response.data.name) {
				  $rootScope.authenticated = true;
			  } else {
				  $rootScope.authenticated = false;
			  }
			  callback && callback();
		  }, function(){
			  $rootScope.authenticated = false;
			  callback && callback();
		  });
		  
		
	  };
	 
	  authenticate();
	  
	  $scope.ceredentials = {};
	  $scope.login = function(){
		  authenticate($scope.credentials, function(){
			if($rootScope.authenticated) {
				$location.path("/manageVisitor");
				$scope.error = false;
			} else {
				$location.path("/login");
				$scope.error = true;
			} 
		  });
	  };
	  
	  $scope.logout = function() {
		  $http.post('logout',{}).finally(function(){
			  $rootScope.authenticated = false;
			  $location.path("/login");
		  });
	  };
	
	
}]);