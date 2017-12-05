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
		templateUrl: 'templates/visitor/add-visitor.html',
	})
	.state('editVisitor',{
		url: '/editVisitor/:visitorId',
		templateUrl: 'templates/visitor/edit-visitor.html',
	})
	.state('login', {
		url: '/login',
		templateUrl: 'login.html'
	})
	.state('listVisitors', {
		url: '/listVisitors',
		templateUrl: 'templates/visitor/manage-visitors.html',
	})
	.state('listSystems', {
		url: '/listSystems',
		templateUrl: 'templates/system/manage-systems.html'
	})
	.state('addSystem', {
		url:'/addSystem',
		templateUrl:'templates/system/add-system.html'
	})
	.state('editSystem',{
		url: '/editSystem/:systemId',
		templateUrl: 'templates/system/edit-system.html',
	})
	.state('createSession',{
		url: '/createSession/:visitorId',
		templateUrl: 'templates/session/create-session.html'
	})
	.state('listSessions',{
		url: '/listSessions',
		templateUrl: 'templates/session/manage-sessions.html'
	});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});


