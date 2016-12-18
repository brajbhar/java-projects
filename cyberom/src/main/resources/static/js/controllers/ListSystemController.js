/**
 * 
 */

module.controller('ListSystemController', function($scope, 
		FilterAndPaginationUtils, 
		usSpinnerService, 
		SpinnerUtils,
		SystemService) {
	
	$scope.systems = {};
	$scope.system = {};
	$scope.systemSearchFilter = {};
	
	$scope.systemSearchFilter.pageNumber = 1;
	$scope.systemSearchFilter.pageSize = 5;
	
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
				"name" : $scope.systemSearchFilter.name ? $scope.visitorSearchFilter.name : '',
				"serial" : $scope.systemSearchFilter.serial ? $scope.visitorSearchFilter.serial : '',
				"pageNumber" : $scope.systemSearchFilter.pageNumber ? $scope.visitorSearchFilter.pageNumber : '',
				"pageSize" : $scope.systemSearchFilter.pageSize ? $scope.visitorSearchFilter.pageSize : ''
		};
		
		return searchFilter;
		
	};
	
});