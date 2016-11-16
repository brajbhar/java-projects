/**
 * 
 */

module.controller('ListSystemController', function($scope, 
		FilterAndPaginationUtils, 
		usSpinnerService, 
		SpinnerUtils,
		SystemService) {
	
	$scope.systems = {};
	$scope.systemSearchFilter = {};
	
	function getSystems() {
		SpinnerUtils.startSpinner('spinner');
		SystemService.getSystems(createVisitorFilter())
		.then(function(data){
			$scope.visitsystems = data.content;
			$scope.systemSearchFilter = FilterAndPaginationUtils.
				populatePagingDataIntoFilter(data, $scope.systemSearchFilter);
			SpinnerUtils.stopSpinner('spinner');
		});
	};
	
	function createSystemFilter() {
		var filterFields = [];
		filterFields.push(buildFilter("name", 
				$scope.visitorSearchFilter.mobile));
		filterFields.push(buildFilter("serial", 
				$scope.visitorSearchFilter.firstName));
		filterFields.push(buildFilter("lastName", 
				$scope.visitorSearchFilter.lastName));
		filterFields.push(buildFilter("pageNumber", 
				$scope.visitorSearchFilter.pageNumber));
		filterFields.push(buildFilter("pageSize", 
				$scope.visitorSearchFilter.pageSize));
		return FilterAndPaginationUtils.createFilter(filterFields);
	};
	
	function buildFilter(name, value) {
		var filter = {};
		filter.name = name;
		filter.value = value ? value : '';
		return filter;
	};
	
	
	
	
});