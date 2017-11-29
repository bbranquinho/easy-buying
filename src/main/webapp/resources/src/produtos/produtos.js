'use strict';

angular.module('easy-buying')
  .controller('ProdutoCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
   $scope.produto = {};
   $scope.produtos = [];
   $scope.categorias = [];


   var produtoUrl = SERVICE_PATH.PRIVATE_PATH + '/product';
   var categoriaUrl = SERVICE_PATH.PRIVATE_PATH + '/productcategory';

   $scope.editProduto = function(produto) {
        $scope.produto = angular.copy(produto);
        $scope.show();
   };

   $scope.deleteProduto = function(produto) {
       RestSrv.delete(produtoUrl, produto, function() {
         $scope.produtos.splice($scope.produtos.indexOf(produto), 1);
         ngNotify.set('Produto \'' + produto.name + '\' deletado.', 'success' );

       });

   };

   $scope.saveProduto = function(produto) {
        if(produto.id) {
            RestSrv.edit(produtoUrl, produto, function() {
                for(var i = 0; i < $scope.produtos.length; i++) {
                    if($scope.produtos[i].id === produto.id) {
                        $scope.produtos[i] = produtos;
                    }

                }
            $scope.hide();

            ngNotify.set('Produto \'' + produto.name + '\' updated.', 'success');
            });

        }else {
            RestSrv.add(produtoUrl, produto, function(newProduto) {
                $scope.produto.push(newProduto);
                $scope.hide();
                ngNotify.set('Produto \'' + produto.name + '\' added.', 'success');
            });


        }

   };

    RestSrv.find(produtoUrl, function(data){
        $scope.produtos = data;
        ngNotify.set('Loaded produto with success.', 'success');
    });

    RestSrv.find(categoriaUrl, function(data){
        $scope.categorias = data;
    });


  });
