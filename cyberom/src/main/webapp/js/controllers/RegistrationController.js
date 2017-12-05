/**
 * 
 */

module.controller('RegistrationController', 
					['$scope','$http','StateService',
                     function($scope, $http, stateService){

	$scope.showInfoAlert = false;
	$scope.showSuccessAlert = false;
	$scope.showSomethingWentWrongAlert = false;
	$scope.showAjaxLoader = false;

	stateService.getStates()
		.then(function(states){
			$scope.states = states;
	});
	
	$scope.populateCities = function() {
		stateService.getCitiesByState($scope.state.id)
			.then(function(cities){
				$scope.cities = cities;
			});
	};
	
	$scope.registerCybercafe = function(form) {
		if(form.$valid) {
			$scope.showAjaxLoader = true;
				$http.post("rest/cybercafes", getCybercafeRegistrationJSONData()).
				success(function(response) {
					$scope.showAjaxLoader = false;
					$scope.showSuccessAlert = true;
					$scope.showSomethingWentWrongAlert = false;
					form.$pristine = true
					form.$valid = true
					
				})
				.error(function(response) {
					$scope.showAjaxLoader = false;
					$scope.showSuccessAlert = false;
					$scope.showSomethingWentWrongAlert = true;
				});
				
		}
	};
	
	function getCybercafeRegistrationJSONData() {
		 var JSONData = {
			"name" : $scope.cybercafeName,
			"phoneNo": $scope.mobileNo,
			"address" : {
				"addressLine1" : $scope.addressLine1,
				"addressLine2" : $scope.addressLine2,
				"city" : {
					"name" : $scope.city.name,
					"id" : $scope.city.id,
					"state" : {
						"name" : $scope.state.name,
						"id" : $scope.state.id
					}	
					
				},
				"pin" : $scope.pin,
			},
			"user" : {
				"userName": $scope.username,
				"password": $scope.password,
				"firstName": $scope.firstName,
				"lastName" : $scope.lastName,
				"email" : $scope.email,
				"mobileNo" : $scope.mobileNo
			}
			
		 };	
		 return JSONData;
	}
	
	
}]);

