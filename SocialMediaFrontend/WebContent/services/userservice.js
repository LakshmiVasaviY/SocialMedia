/**
 * UserService
 */
app.factory('UserService',function($http){
	var userService={}
	var BASE_URL="http://localhost:8081/SocialMediaMiddleware"
	userService.registration=function(user){
		var url=BASE_URL+ "/register"
		return $http.post(url,user)
	}
	
	userService.login=function(user){
		var url=BASE_URL + "/login"
		return $http.put(url,user)
	}
	
	userService.getAllJobs=function(){
	   var url=BASE_URL+"/getalljobs"	
	   return $http.get(url)
	}
	
	return userService;
})