'use strict';

angular.module('easy-buying')
  .controller('OrcamentoCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
   $scope.orcamento = {};
   $scope.orcamentos = [];
   $scope.pedido = {};
   $scope.pedidos = [];


   var orcamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/quotation';
   var pedidoUrl = SERVICE_PATH.PRIVATE_PATH + '/productrequest';

   $scope.editOrcamento = function(orcamento) {
        $scope.orcamento = angular.copy(orcamento);
        $scope.show();
   };

   $scope.deleteOrcamento = function(orcamento) {
       RestSrv.delete(orcamentoUrl, orcamento, function() {
         $scope.orcamentos.splice($scope.orcamentos.indexOf(orcamento), 1);
         ngNotify.set('Orcamento \'' + orcamento.name + '\' deletado.', 'success' );

       });

   };

   $scope.saveOrcamento = function(orcamento) {
        if(orcamento.id) {
            RestSrv.edit(orcamentoUrl, orcamento, function() {
                for(var i = 0; i < $scope.orcamentos.length; i++) {
                    if($scope.orcamentos[i].id === orcamentos.id) {
                        $scope.orcamentos[i] = orcamentos;
                    }

                }
            $scope.hide();

            ngNotify.set('Orcamento \'' + orcamento.name + '\' updated.', 'success');
            });

        }else {
            RestSrv.add(orcamentoUrl, orcamento, function(newOrcamento) {
                $scope.orcamento.push(newOrcamento);
                $scope.hide();
                ngNotify.set('Orcamento \'' + orcamento.name + '\' added.', 'success');
            });


        }

   };

    RestSrv.find(pedidoUrl, function(data){
        $scope.pedidos = data;
        ngNotify.set('Loaded pedido with success.', 'success');
    });

    RestSrv.find(orcamentoUrl, function(data){
        $scope.orcamentos = data;
    });

  });
