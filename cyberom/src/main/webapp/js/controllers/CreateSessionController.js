/**
 * 
 */
module.controller('CreateSessionController', function($scope, $location, $stateParams,
		usSpinnerService, 
		SpinnerUtils, VisitorService, SystemService, SessionService){
	
	$scope.session = {};
	$scope.session.visitor = {};
	$scope.visitors = [];
	$scope.session.visitor.id = $stateParams.visitorId;
	$scope.availableSystems = [];
	$scope.systemSearchFilter = {};
	$scope.visitorSearchFilter = {};
	
	$scope.bookingDurations = [30, 60];
	
	if($scope.session.visitor.id) {
		
		VisitorService.getVisitor($scope.session.visitor.id)
		.then(function(visitor){
			$scope.session.visitor = visitor;
		});
	} else {
		VisitorService.getVisitors(createVisitorFilter())
		.then(function(visitors){
			$scope.visitors = visitors.content;
		});
	}
	
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
	
	function createVisitorFilter() {
		var searchFilter = {
				"mobileNumber" : $scope.visitorSearchFilter.mobile ? $scope.visitorSearchFilter.mobile : '',
				"firstName" : $scope.visitorSearchFilter.firstName ? $scope.visitorSearchFilter.firstName : '',
				"lastName" : $scope.visitorSearchFilter.lastName ? $scope.visitorSearchFilter.lastName : '',
				"pageNumber" : $scope.visitorSearchFilter.pageNumber ? $scope.visitorSearchFilter.pageNumber : '',
				"pageSize" : $scope.visitorSearchFilter.pageSize ? $scope.visitorSearchFilter.pageSize : '',
				"isPaginationRequired" : "false"
		};
		
		return searchFilter;
		
	};
	
	
	$scope.startSession = function(){
		SpinnerUtils.startSpinner();
		var startTime = new Date();
		$scope.session.systemUsages = [
		                              {"system":$scope.session.system, "startTime": startTime
		                            	  }                        
		                              ];
		$scope.session.startTime = startTime;
		SessionService.addSession($scope.session).then(function(data) {
			console.log("added session");
			$location.path("/listSessions");
		}).catch(function(e){
			$scope.showSomethingWentWrongAlert = true;
			$scope.errorMessage = e.message;
		}).finally(function(){
			SpinnerUtils.stopSpinner();
		});
		
	};
	
	
});