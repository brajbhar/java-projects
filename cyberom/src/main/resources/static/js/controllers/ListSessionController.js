/**
 * 
 */
module.controller('ListSessionController', function($scope,  
		SessionService,
		FilterAndPaginationUtils,
		usSpinnerService,
		SpinnerUtils) {
	
	$scope.sessionSearchFilter = {};
	
	function createSessionFilter() {
		
		var searchFilter = {
				"visitorId" : $scope.sessionSearchFilter.visitor ? $scope.sessionSearchFilter.visitor.id : '';
				"pageNumber" : $scope.sessionSearchFilter.pageNumber ? $scope.sessionSearchFilter.pageNumber : '';
				"pageSize" : $scope.sessionSearchFilter.pageSize ? $scope.sessionSearchFilter.pageSize : '';
		};
		
	};
	
});