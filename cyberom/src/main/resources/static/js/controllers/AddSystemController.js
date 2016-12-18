/**
 * 
 */
module.controller('AddSystemController', function($scope, $location, SystemService, CybercafeService, SpinnerUtils){
	
	$scope.system = {};
	
	CybercafeService.getCybercafeById(1)
	.then(function(cybercafe){
		$scope.system.cybercafe = cybercafe;
	});

	
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