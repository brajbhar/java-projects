/**
 * 
 */

module.directive('checkForDuplicate', function($q, $http) {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModel) {
            ngModel.$asyncValidators.duplicate = function(modelValue, viewValue) {
            	var deferred = $q.defer();
                $http.get(attrs['checkForDuplicateUrl'] + viewValue)
    			.success(function(response){
    				if(typeof response === 'object') {
    					deferred.reject();
    				}
    				deferred.resolve();
    			});
                return deferred.promise;
            };
        }
    };
});