/**
 * 
 */
module.controller('CreateSessionController', function($scope, $location, $stateParams,
		usSpinnerService, 
		SpinnerUtils, VisitorService, SystemService, SessionService){
	
	$scope.session = {};
	$scope.session.visitor = {};
	$scope.session.visitor.id = $stateParams.visitorId;
	$scope.availableSystems = [];
	$scope.systemSearchFilter = {};
	
	$scope.bookingDurations = [30, 60];
	
	VisitorService.getVisitor($scope.session.visitor.id)
	.then(function(visitor){
		$scope.session.visitor = visitor;
	});
	
	getAvailableSystems();
	
	function getAvailableSystems() {
		SpinnerUtils.startSpinner('spinner');
		SystemService.getSystems(createSystemFilter())
		.then(function(data){
			$scope.systems = data.content;
			$scope.availableSystems = $scope.systems.filter(function(system){
				return !system.occupied;
			});
			SpinnerUtils.stopSpinner('spinner');
		});
	};
	
	function createSystemFilter() {
		var searchFilter = {
				"name" : $scope.systemSearchFilter.name ? $scope.systemSearchFilter.name : '',
				"serial" : $scope.systemSearchFilter.serial ? $scope.systemSearchFilter.serial : '',
				"pageNumber" : $scope.systemSearchFilter.pageNumber ? $scope.systemSearchFilter.pageNumber : '',
				"pageSize" : $scope.systemSearchFilter.pageSize ? $scope.systemSearchFilter.pageSize : ''
		};
		
		return searchFilter;
		
	};
	
	
	$scope.startSession = function(){
		var startTime = new Date();
		$scope.session.systemUsages = [
		                              {"system":$scope.session.system, "startTime": startTime
		                            	  }                        
		                              ];
		$scope.session.startTime = startTime;
		SessionService.addSession($scope.session).then(function(data) {
			console.log("added session");
		});
		
	};
	
	
});