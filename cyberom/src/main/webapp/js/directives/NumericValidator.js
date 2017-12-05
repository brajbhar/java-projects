/**
 * 
 */

var INTEGER_REGEXP = /^\-?\d+$/;

module.directive('numeric', function(){
	return {
		require: 'ngModel',
		link: function(scope, elm, attrs, ctrl){
			ctrl.$validators.numeric = function(modelValue, viewValue) {
				if(ctrl.$isEmpty(modelValue)) {
					return true;
				}
				if(INTEGER_REGEXP.test(viewValue)) {
					return true;
				}
				return false;
			};
			
		}
	};
});