var myApp = angular.module('myApp', []);

myApp
    .controller('control',['$scope',function($scope){
        $scope.list = [];
        var index=0;
        $scope.add = function(){
            $scope.list.push({"index":index++});
        }
    }
]);