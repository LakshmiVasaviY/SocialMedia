/**
 * UserCtrl
 */
app.controller('UserCtrl',function($scope,UserService,$location){
	//Function for Registration
	$scope.registration=function(user){
		console.log(user)
		UserService.registration(user).then(
				function(response){
					alert('Registered successfully.. please login again')
					$location.path('/login')
				},function(response){
					$scope.error=response.data//ErrorClazz object in JSON fmt
				})
	}
	
})