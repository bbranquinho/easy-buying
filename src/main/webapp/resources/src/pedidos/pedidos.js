'use strict';

angular.module('easy-buying')
  .controller('PedidoCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
   $scope.produto = {};
   $scope.produtos = [];
   $scope.pedido = {};
   $scope.pedidos = [];


   var produtoUrl = SERVICE_PATH.PRIVATE_PATH + '/product';
   var pedidoUrl = SERVICE_PATH.PRIVATE_PATH + '/productrequest';

   $scope.editPedido = function(pedido) {
        $scope.pedido = angular.copy(pedido);
        $scope.show();
   };

   $scope.deletePedido = function(pedido) {
       RestSrv.delete(produtoUrl, pedido, function() {
         $scope.pedidos.splice($scope.pedidos.indexOf(pedido), 1);
         ngNotify.set('Pedido \'' + pedido.name + '\' deletado.', 'success' );

       });

   };

   $scope.savePedido = function(pedido) {
        if(pedido.id) {
            RestSrv.edit(pedidoUrl, pedido, function() {
                for(var i = 0; i < $scope.pedidos.length; i++) {
                    if($scope.pedidos[i].id === pedidos.id) {
                        $scope.pedidos[i] = pedidos;
                    }

                }
            $scope.hide();

            ngNotify.set('Pedido \'' + pedido.name + '\' updated.', 'success');
            });

        }else {
            RestSrv.add(pedidoUrl, pedido, function(newPedido) {
                $scope.pedido.push(newPedido);
                $scope.hide();
                ngNotify.set('Pedido \'' + pedido.name + '\' added.', 'success');
            });


        }

   };

    RestSrv.find(pedidoUrl, function(data){
        $scope.pedidos = data;
        ngNotify.set('Loaded pedido with success.', 'success');
    });

    RestSrv.find(produtoUrl, function(data){
        $scope.produtos = data;
    });


  });
