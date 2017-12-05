/**
 * 
 */
module.factory('SpinnerUtils', ['usSpinnerService', function(usSpinnerService){
	var factory = {};
	
	factory.startSpinner = function(spinnerName) {
		usSpinnerService.spin(spinnerName);
	},
	factory.stopSpinner = function(spinnerName) {
		usSpinnerService.stop(spinnerName);
	};
	
	return factory;
}]);