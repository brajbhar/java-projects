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
	
	/*factory.buildQueryString = function buildQueryString(filters) {
		var queryString = "?";
		for(var i=0; i<filters.length;i++) {
			var filter = filters[i];
			if(i > 0) {
				queryString += "&";
			}
			queryString += filter.name + "=" + filter.value;
		}
		return queryString;
	};*/
	
	factory.buildQueryString = function(searchFilter) {
		var queryString = "?";
		var i = 0;
		for(var key in searchFilter) {
			if(i > 0) {
				queryString += "&";
			}
			if(searchFilter.hasOwnProperty(key)) {
				queryString += key + "=" + searchFilter[key];
				i = i + 1;
			}
			
		}
		return queryString;
	};
	
	return factory;
	
}]);