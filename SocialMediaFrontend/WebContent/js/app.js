/**
 * Angular JS module
 */
var app=angular.module("app",['ngRoute','ngCookies'])

app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{controller:'UserCtrl',templateUrl:'views/registrationform.html'})
	.when('/login',{controller:'UserCtrl',templateUrl:'views/login.html'})
	.when('/home',{templateUrl:'views/home.html'})
	.when('/updateprofile',{controller:'UserCtrl',templateUrl:'views/updateprofile.html'})
	.when('/addjob',{controller:'JobCtrl}',templateUrl:'views/jobform.html'})
	.when('/getalljobs',{controller:'JobCtrl',templateUrl:'views/listofjobs.html'})
	.otherwise({templateUrl:'views/home.html'})
})
//Angular module gets instantiated, app.run() will get executed
//restore userdetails to the variable user in $rootScope
app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.user==undefined)
		$rootScope.user=$cookieStore.get('userDetails')
		
		$rootScope.logout=function(){
		   alert('Entering the function logout')
		   UserService.logout().then(function(response){
			   //delete the user variable from $rootScope
			   //clear the cookie
			   //redirect the user to login page
			   delete $rootScope.user
			   $cookieStore.remove('userDetails')
			   $location.path('/login')
		   },function(response){
               //if $rootScope.user is not undefined,clear the cookie and redirect the user to login page
			   if($rootScope.user!=undefined)
			   delete $rootScope.user
			   $cookieStore.remove('userDetails')
			   $location.path('/login')
		   })
	   }	
		
})
