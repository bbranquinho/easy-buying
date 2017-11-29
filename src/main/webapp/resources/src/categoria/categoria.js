'use strict';

angular.module('easy-buying')
  .controller('CategoriaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
   $scope.categoria = {};
   $scope.categorias = [];
   $scope.showAddEditCategoria = false;


   $scope.show = function() {
     $scope.showAddEditCategoria = true;
   };

   $scope.hide = function() {
        $scope.showAddEditCategoria = false;
        $scope.categoria = {};
   };

   var categoriaUrl = SERVICE_PATH.PRIVATE_PATH + '/productcategory';

   $scope.editCategoria = function(categoria) {
        $scope.categoria = angular.copy(categoria);
        $scope.show();
   };

   $scope.deleteCategoria = function(categoria) {
       RestSrv.delete(categoriaUrl, categoria, function() {
         $scope.categorias.splice($scope.categorias.indexOf(categoria), 1);
         ngNotify.set('Categoria \'' + categoria.name + '\' deletado.', 'success' );

       });

   };

   $scope.saveCategoria = function(categoria) {
        if(categoria.id) {
            RestSrv.edit(categoriaUrl, categoria, function() {
                for(var i = 0; i < $scope.categorias.length; i++) {
                    if($scope.categorias[i].id === categoria.id) {
                        $scope.categorias[i] = categoria;
                    }

                }
            $scope.hide();

            ngNotify.set('Categoria \'' + categoria.name + '\' updated.', 'success');
            });

        }else {
            RestSrv.add(categoriaUrl, categoria, function(newCategoria) {
                $scope.categorias.push(newCategoria);
                $scope.hide();
                ngNotify.set('Categoria \'' + categoria.name + '\' added.', 'success');
            });


        }

   };

    RestSrv.find(categoriaUrl, function(data){
        $scope.categorias = data;
        ngNotify.set('Loaded categoria with success.', 'success');
    });


  });
