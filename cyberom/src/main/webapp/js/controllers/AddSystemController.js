/**
 * 
 */
module.controller('AddSystemController', function($scope, $location, SystemService, CybercafeService, SpinnerUtils){
	
	$scope.system = {};
	
	CybercafeService.getCybercafeById(1)
	.then(function(cybercafe){
		$scope.system.cybercafe = cybercafe;
	});
	
	$scope.hasError = function() {
		var form = this.form;
		if((form.name.$dirty && form.name.$invalid) 
				|| (form.name.$dirty && form.serial.$invalid)) {
			return true;
		}
		return false;
	};

	
	$scope.saveSystem = function() {
		if($scope.system.id) {
			
		}
		else {
			SpinnerUtils.startSpinner();
			SystemService.addSystem($scope.system)
				.then(function(system){
					$location.path("/listSystems")
				})
				.catch(function(e) {
					
				})
				.finally(function(){
					SpinnerUtils.stopSpinner();
				});
		}
	}
	
});