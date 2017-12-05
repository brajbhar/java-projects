/**
 * 
 */
module.controller('EditVisitorController', function($scope, $http, $location, $state, $stateParams,
		StateService, 
		CybercafeService, 
		VisitorService, 
		usSpinnerService,
		SpinnerUtils) {
	
	$scope.showSomethingWentWrongAlert = false;
	$scope.visitor = {};
	SpinnerUtils.startSpinner('spinner')
	var visitorId = $stateParams.visitorId;
	VisitorService.getVisitor(visitorId)
		.then(function(visitor){
			
			
			StateService.getStates()
				.then(function(states){
					$scope.states = states;
					//Populate state of visitor object
					$scope.states.forEach(function(state){
						if(state.id === visitor.address.city.state.id) {
							visitor.address.state = state;
						}
					});
					
					//Populate city of visitor object
					StateService.getCitiesByState(visitor.address.state.id)
						.then(function(cities){
							$scope.cities = cities;
							cities.forEach(function(city){
								if(city.id === visitor.address.city.id) {
									visitor.address.city = city;
								}
							});
							SpinnerUtils.stopSpinner('spinner');
							
						});
					
			});
		
			CybercafeService.getIDCardTypes()
				.then(function(idCardTypes){
					$scope.typesOfIdCards = idCardTypes;
					//Populate id card type of visitor object
					$scope.typesOfIdCards.forEach(function(idCardType){
						if(idCardType.id === visitor.idCardType.id) {
							visitor.idCardType=idCardType;
						}
					});
				});
		
			CybercafeService.getCybercafeById(1)
				.then(function(cybercafe){
					$scope.visitor.cybercafe = cybercafe;
				});
			
			$scope.visitor = visitor;
		});

	
	
	$scope.saveVisitor = function() {
		if($scope.visitor.id) {
			SpinnerUtils.startSpinner();
			VisitorService.edit(getVisitorJSONData())
			.then(function(visitor) {
				$location.path("/listVisitors")
			})
			.catch(function(e) {
				$scope.showSomethingWentWrongAlert = true;
				$scope.errorMessage = e.message;
			})
			.finally(function(){
				SpinnerUtils.stopSpinner();
			});
			
		} else {
			VisitorService.save(getVisitorJSONData())
			.then(function(visitor) {
				$location.path("/listVisitors")
			})
			.catch(function(e) {
				$scope.showSomethingWentWrongAlert = true;
				$scope.errorMessage = e.message;
			})
			.finally(function(){
				SpinnerUtils.stopSpinner();
			});
			
		}
	};
	
	function getVisitorJSONData() {
		var JSONData = {
				"id": $scope.visitor.id,
				"firstName" : $scope.visitor.firstName,
				"lastName" : $scope.visitor.lastName,
				"age" : $scope.visitor.age,
				"sex" : $scope.visitor.sex,
				"mobile" : $scope.visitor.mobile,
				"address" : {
					"addressLine1" : $scope.visitor.address.addressLine1,
					"addressLine2" : $scope.visitor.address.addressLine2,
					"city" : {
						"name" : $scope.visitor.address.city.name,
						"id" : $scope.visitor.address.city.id,
						"state" : {
							"name" : $scope.visitor.address.state.name,
							"id" : $scope.visitor.address.state.id
						}	
						
					},
					"pin" : $scope.visitor.address.pin,
				},
				"cybercafe" : $scope.visitor.cybercafe,
				"idCardNumber" : $scope.visitor.idCardNumber,
				"idCardType" : {
					"name" : $scope.visitor.idCardType.name,
					"id" : $scope.visitor.idCardType.id
				}
			 };	
			 return JSONData;
	}
	
	$scope.populateCities = function() {
		StateService.getCitiesByState($scope.visitor.address.state.id)
			.then(function(cities){
				$scope.cities = cities;
			});
	};
});