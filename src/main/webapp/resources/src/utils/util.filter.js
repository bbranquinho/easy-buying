'use strict';

angular.module('easy-buying')
  .filter('formatPermission', function() {
    return function(input) {
      switch (input) {
        case 'ROLE_ADMIN':
          return 'Administrator';
        break;

        case 'ROLE_USER':
          return 'User';
        break;

        case 'ROLE_CLIENTE':
          return 'Cliente';
        break;

        case 'ROLE_FORNECEDOR':
           return 'Fornecedor';
         break;
        default:
          return 'Não Informado';
        break;
      };
    };
  });
