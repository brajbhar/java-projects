/**
 * 
 */
module.controller('ListSessionController', function($scope,  
		SessionService,
		FilterAndPaginationUtils,
		usSpinnerService,
		SpinnerUtils) {
	
	$scope.sessionSearchFilter = {};
	
	$scope.sessionSearchFilter.pageNumber = 1;
	$scope.sessionSearchFilter.pageSize = 5;
	
	getSessions();
	
	function getSessions() {
		SpinnerUtils.startSpinner('spinner');
		SessionService.getSessions(createSessionFilter())
			.then(function(data) {
				$scope.sessions = data.content;
				$scope.sessionSearchFilter = FilterAndPaginationUtils.
				populatePagingDataIntoFilter(data, $scope.sessionSearchFilter);
				SpinnerUtils.stopSpinner('spinner');	
		});
	};
	
	function createSessionFilter() {
		
		var searchFilter = {
				"visitorId" : $scope.sessionSearchFilter.visitor ? $scope.sessionSearchFilter.visitor.id : '',
				"pageNumber" : $scope.sessionSearchFilter.pageNumber ? $scope.sessionSearchFilter.pageNumber : '',
				"pageSize" : $scope.sessionSearchFilter.pageSize ? $scope.sessionSearchFilter.pageSize : ''
		};
		return searchFilter;
		
	};
	
	$scope.applySessionFilterByPageNumber = function(pageNumber) {
		$scope.sessionSearchFilter.pageNumber = pageNumber;
		getSessions();
	};
	
});