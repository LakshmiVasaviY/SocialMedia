/**
 * JobCtrl
 */
app.controller('JobCtrl',function($scope,$location,JobService){
		$scope.addJob=function(job){
				JobService.addJob(job).then(function(response){
					alert('Job Details inserted successfully')
					$location.path('/getalljobs')
				},function(response){
					if(response.data.errorCode==4)
						$location.path('/login')
					$scope.error=response.data
				})
		}
})