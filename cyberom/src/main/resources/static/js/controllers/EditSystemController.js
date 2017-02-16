module.controller('EditSystemController', function($scope, $location, $stateParams, SystemService, CybercafeService, SpinnerUtils){
	
	$scope.system = {};
	
	var systemId = $stateParams.systemId;
	
	SystemService.getSystem(systemId)
		.then(function(system){
			$scope.system = system;
			CybercafeService.getCybercafeById(1)
			.then(function(cybercafe){
				$scope.system.cybercafe = cybercafe;
			});
		});
	
	

	
	$scope.saveSystem = function() {
		if($scope.system.id) {
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