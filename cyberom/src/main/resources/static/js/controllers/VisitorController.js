/**
 * 
 */
module.controller('VisitorController', ['$scope', '$http', '$location','$state','$stateParams','StateService',
                                        'CybercafeService','VisitorService','usSpinnerService', 
                                        function($scope, $http, $location, $state,$stateParams,stateService, 
                                        		cybercafeService, visitorService, usSpinnerService){
	
	$scope.showSomethingWentWrongAlert = false;
	$scope.visitor = {};
	$scope.visitorSearchFilter = {};
	$scope.visitors = [];
	$scope.currentStateName = $state.current.name;
	$scope.picture = false;
	
	$scope.visitorSearchFilter.pageNumber = 1;
	$scope.visitorSearchFilter.pageSize = 5;
	
	
	$scope.startSpin = function(){
        usSpinnerService.spin('spinner');
    }
    $scope.stopSpin = function(){
        usSpinnerService.stop('spinner');
    }
	
	
	if($scope.currentStateName === 'manageVisitors') {
		getVisitors();
	} else if($scope.currentStateName === 'addVisitor') {
		$scope.startSpin();
		stateService.getStates()
			.then(function(states){
				$scope.states = states;
			});
		
		cybercafeService.getIDCardTypes()
			.then(function(idCardTypes){
				$scope.typesOfIdCards = idCardTypes;
			});
	
		cybercafeService.getCybercafeById(1)
			.then(function(cybercafe){
				$scope.visitor.cybercafe = cybercafe;
			});
	
	} else if($scope.currentStateName === 'editVisitor') {
		$scope.startSpin();
		var visitorId = $stateParams.visitorId;
		visitorService.getVisitor(visitorId)
			.then(function(visitor){
				
				
				stateService.getStates()
					.then(function(states){
						$scope.states = states;
						//Populate state of visitor object
						$scope.states.forEach(function(state){
							if(state.id === visitor.address.city.state.id) {
								visitor.address.state = state;
							}
						});
						
						//Populate city of visitor object
						stateService.getCitiesByState(visitor.address.state.id)
							.then(function(cities){
								$scope.cities = cities;
								cities.forEach(function(city){
									if(city.id === visitor.address.city.id) {
										visitor.address.city = city;
									}
								});
								$scope.stopSpin();
								
							});
						
				});
			
				cybercafeService.getIDCardTypes()
					.then(function(idCardTypes){
						$scope.typesOfIdCards = idCardTypes;
						//Populate id card type of visitor object
						$scope.typesOfIdCards.forEach(function(idCardType){
							if(idCardType.id === visitor.idCardType.id) {
								visitor.idCardType=idCardType;
							}
						});
					});
			
				cybercafeService.getCybercafeById(1)
					.then(function(cybercafe){
						$scope.visitor.cybercafe = cybercafe;
					});
				
				$scope.visitor = visitor;
			});
		
		
	}
	
		
	$scope.populateCities = function() {
		stateService.getCitiesByState($scope.visitor.address.state.id)
			.then(function(cities){
				$scope.cities = cities;
			});
	};
	
	
	$scope.saveVisitor = function() {
		if($scope.visitor.id) {
			$scope.startSpin();
			visitorService.edit(getVisitorJSONData())
			.then(function(visitor) {
				$scope.stopSpin();
				$location.path("/manageVisitor")
			})
			.catch(function(e) {
				$scope.stopSpin();
				$scope.showSomethingWentWrongAlert = true;
				$scope.errorMessage = e.message;
			})
			.finally(function(){
				$scope.stopSpin();
			});
			
		} else {
			$scope.startSpin();
		visitorService.save(getVisitorJSONData())
			.then(function(visitor) {
				$scope.stopSpin();
				$location.path("/manageVisitor")
			})
			.catch(function(e) {
				$scope.stopSpin();
				$scope.showSomethingWentWrongAlert = true;
				$scope.errorMessage = e.message;
			})
			.finally(function(){
				$scope.stopSpin();
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
	
	function createVisitorFilter() {
		var visitorFilter = [];
		visitorFilter.push(buildFilter("mobileNumber", $scope.visitorSearchFilter.mobile ? $scope.visitorSearchFilter.mobile:''));
		visitorFilter.push(buildFilter("firstName", $scope.visitorSearchFilter.firstName ? $scope.visitorSearchFilter.firstName:''));
		visitorFilter.push(buildFilter("lastName", $scope.visitorSearchFilter.lastName ? $scope.visitorSearchFilter.lastName:''));
		visitorFilter.push(buildFilter("pageNumber", $scope.visitorSearchFilter.pageNumber ? $scope.visitorSearchFilter.pageNumber:''));
		visitorFilter.push(buildFilter("pageSize", $scope.visitorSearchFilter.pageSize ? $scope.visitorSearchFilter.pageSize:''));
		return visitorFilter;
	}
	
	function buildFilter(name, value) {
		var filter = {};
		filter.name = name;
		filter.value = value;
		return filter;
	}
	
	function getVisitors() {
		$scope.startSpin();
		visitorService.getVisitors(createVisitorFilter())
		.then(function(data){
			$scope.visitors = data.content;
			$scope.visitorSearchFilter.totalPages = data.totalPages;
			$scope.visitorSearchFilter.currentPageNumber = data.number + 1;
			$scope.visitorSearchFilter.pageNumbers = [];
			for(var i=1;i<=data.totalPages;i++) {
				$scope.visitorSearchFilter.pageNumbers.push(i);
			}
			$scope.stopSpin();
		});
	}
	
	$scope.applyVisitorFilterByPageNumber = function(pageNumber) {
		$scope.visitorSearchFilter.pageNumber = pageNumber;
		getVisitors();
	};
	
	$scope.findVisitors = function() {
		getVisitors();
	};
	
}]);