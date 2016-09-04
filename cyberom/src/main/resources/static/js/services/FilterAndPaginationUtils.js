/**
 * 
 */
module.factory('FilterAndPaginationUtils', [function(){

	var factory = {};
	
	factory.createFilter = function(filterFields) {
		var filters = [];
		filterFields.forEach(function(field){
			filters.push(field);
		});
		return filters;
	},
	
	factory.populatePagingDataIntoFilter = function(records, filter) {
		filter.totalPages = records.totalPages;
		filter.currentPageNumber = records.number + 1;
		filter.pageNumbers = [];
		for(var i=1;i<=records.totalPages;i++) {
			filter.pageNumbers.push(i);
		}
		return filter;
	};
	
	
	return factory;
	
}]);