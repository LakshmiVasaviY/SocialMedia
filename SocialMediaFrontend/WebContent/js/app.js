/**
 * Angular JS module
 */
var app=angular.module("app",['ngRoute'])

app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{controller:'UserCtrl',templateUrl:'views/registrationform.html'})
	.when('/login',{controller:'UserCtrl',templateUrl:'views/login.html'})
	.when('/home',{templateUrl:'views/home.html'})
	.when('/getalljobs',{controller:'UserCtrl',templateUrl:'views/getalljobs.html'})
	.otherwise({templateUrl:'views/home.html'})
})
//Angular module gets instantiated, app.run() will get executed
//restore userdetails to the variable user inn $rootScope
//app.run(function($rootScope,$cookieStore,UserService,$location){
	//if($rootScope.user==undefined)
//})		$rootScope.