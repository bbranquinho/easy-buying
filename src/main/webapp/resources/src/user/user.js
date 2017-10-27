'use strict';

angular.module('easy-buying')
  .controller('UserCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
    //$scope.user = {};
    //mock user
    $scope.user = {name: 'Valentine',
                   sobreNome: 'Melton',
                   email: 'mi@Donec.edu',
                   phone: '34975626450',
                   password: 'IWL65DAK1DY'};


    $scope.users = [];
    $scope.permissions = [];
    $scope.showAddEditUser = false;

    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };

    // Manage CRUD operations.
    var userUrl = SERVICE_PATH.PUBLIC_PATH + '/user';


    $scope.editUser = function(user) {
      $scope.user = angular.copy(user);
      $scope.show();
    };

    $scope.deleteUser = function(user) {
      RestSrv.delete(userUrl, user, function() {
        $scope.users.splice($scope.users.indexOf(user), 1);
        ngNotify.set('User \'' + user.name + '\' deleted.', 'success');
      });
    };

    $scope.saveUser = function(user) {
        debugger;
      if (user.id) {
        RestSrv.edit(userUrl, user, function() {
          delete user.password;

          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }

          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' updated.', 'success');
        });
      } else {
        if(user.permissions == null){
         user.permissions = {id:2,role:"ROLE_USER"};
        }
        RestSrv.add(userUrl, user, function(newUser) {
          $scope.users.push(newUser);
          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' added.', 'success');
        });
      }
    };

    // Request all data (permission and user).
    var permissionUrl = SERVICE_PATH.PUBLIC_PATH + '/permission';

    RestSrv.find(permissionUrl, function(data) {
      $scope.permissions = data;

      RestSrv.find(userUrl, function(data) {
        $scope.users = data;
        ngNotify.set('Loaded users with success.', 'success');
      });
    });

  });
