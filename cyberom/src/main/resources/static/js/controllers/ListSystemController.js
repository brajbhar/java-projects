/**
 * 
 */

module.controller('ListSystemController', function($scope, 
		FilterAndPaginationUtils, 
		usSpinnerService, 
		SpinnerUtils,
		SystemService) {
	
	$scope.systemSearchFilter = {};
	
	$scope.systemSearchFilter.pageNumber = 1;
	$scope.systemSearchFilter.pageSize = 5;
	
	getSystems();
	
	function getSystems() {
		SpinnerUtils.startSpinner('spinner');
		SystemService.getSystems(createSystemFilter())
		.then(function(data){
			$scope.systems = data.content;
			$scope.systemSearchFilter = FilterAndPaginationUtils.
				populatePagingDataIntoFilter(data, $scope.systemSearchFilter);
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
	
});