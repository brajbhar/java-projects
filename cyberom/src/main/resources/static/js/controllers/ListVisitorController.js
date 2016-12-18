/**
 * 
 */

module.controller('ListVisitorController', function($scope, 
		StateService, 
		VisitorService,
		FilterAndPaginationUtils,
		usSpinnerService,
		SpinnerUtils) {
	
	$scope.visitorSearchFilter = {};
	
    $scope.visitorSearchFilter.pageNumber = 1;
	$scope.visitorSearchFilter.pageSize = 5;
    
    getVisitors();
	
	function getVisitors() {
		SpinnerUtils.startSpinner('spinner');
		VisitorService.getVisitors(createVisitorFilter())
		.then(function(data){
			$scope.visitors = data.content;
			$scope.visitorSearchFilter = FilterAndPaginationUtils.
				populatePagingDataIntoFilter(data, $scope.visitorSearchFilter);
			SpinnerUtils.stopSpinner('spinner');
		});
	};
	
	function createVisitorFilter() {
		var searchFilter = {
				"mobileNumber" : $scope.visitorSearchFilter.mobile ? $scope.visitorSearchFilter.mobile : '',
				"firstName" : $scope.visitorSearchFilter.firstName ? $scope.visitorSearchFilter.firstName : '',
				"lastName" : $scope.visitorSearchFilter.lastName ? $scope.visitorSearchFilter.lastName : '',
				"pageNumber" : $scope.visitorSearchFilter.pageNumber ? $scope.visitorSearchFilter.pageNumber : '',
				"pageSize" : $scope.visitorSearchFilter.pageSize ? $scope.visitorSearchFilter.pageSize : ''
		};
		
		return searchFilter;
	}
	
	$scope.applyVisitorFilterByPageNumber = function(pageNumber) {
		$scope.visitorSearchFilter.pageNumber = pageNumber;
		getVisitors();
	};
	
	
});