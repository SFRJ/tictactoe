var myApp = angular.module('myApp',[]);

var gameBoardDto = {
player1:"",
player2:"",
topleft:"",
top:"",
topright:"",
left:"",
middle:"",
right:"",
bottomleft:"",
bottom:"",
bottomright:""
};

myApp.controller('displayPageController', function($scope,$http) {

  $scope.playPage = function(selection) {
      $http({
            method: 'POST',
            url: 'http://localhost:8080/play',
            data: selection,
            headers: {'Content-Type': 'application/json;charset=UTF-8'}
        }).success(function(response) {
              $scope.gameBoardDto = JSON.parse(JSON.stringify(response));
          }.bind(this));
  };
});