/**
 * 
 */

var module = angular.module('cyberom', ['ui.router','ngMessages', 'angularSpinner']);

module.config(function($urlRouterProvider, $stateProvider, $httpProvider){
	
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('register',{
		url: '/register',
		templateUrl: 'register-cybercafe.html'
	})
	.state('addVisitor', {
		url: '/addVisitor',
		templateUrl: 'add-visitor.html',
	})
	.state('editVisitor',{
		url: '/editVisitor/:visitorId',
		templateUrl: 'edit-Visitor.html',
	})
	.state('login', {
		url: '/login',
		templateUrl: 'login.html'
	})
	.state('listVisitors', {
		url: '/listVisitors',
		templateUrl: 'manage-visitors.html',
	})
	.state('listSystems', {
		url: '/listSystems',
		templateUrl: 'manage-systems.html'
	})
	.state('addSystem', {
		url:'/addSystem',
		templateUrl:'add-system.html'
	});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});


