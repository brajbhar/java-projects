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
		templateUrl: 'edit-visitor.html',
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
	})
	.state('editSystem',{
		url: '/editSystem/:systemId',
		templateUrl: 'edit-system.html',
	})
	.state('createSession',{
		url: '/createSession/:visitorId',
		templateUrl: 'create-session.html'
	})
	.state('listSession',{
		url: '/listSessions',
		templateUrl: 'manage-sessions.html'
	});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});


