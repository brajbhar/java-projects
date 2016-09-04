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
		var filterFields = [];
		filterFields.push(buildFilter("mobileNumber", 
				$scope.visitorSearchFilter.mobile));
		filterFields.push(buildFilter("firstName", 
				$scope.visitorSearchFilter.firstName));
		filterFields.push(buildFilter("lastName", 
				$scope.visitorSearchFilter.lastName));
		filterFields.push(buildFilter("pageNumber", 
				$scope.visitorSearchFilter.pageNumber));
		filterFields.push(buildFilter("pageSize", 
				$scope.visitorSearchFilter.pageSize));
		return FilterAndPaginationUtils.createFilter(filterFields);
	}
	
	function buildFilter(name, value) {
		var filter = {};
		filter.name = name;
		filter.value = value ? value : '';
		return filter;
	}
	
	$scope.applyVisitorFilterByPageNumber = function(pageNumber) {
		$scope.visitorSearchFilter.pageNumber = pageNumber;
		getVisitors();
	};
	
	
});