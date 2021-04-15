'use strict';
var module = angular.module('recordServices', []);
module.service('recordServices', ['$http', '$q', function ($http, $q) {
    var recordServices  = {};

    recordServices.list = function () {
        return $http({ method: 'GET', url: '/v2/record/list'});
    };

    recordServices.insert = function (inputData) {
        var params ={
            data: inputData
        };
        return $http({ method: 'POST', url: '/v2/record/insert', data: params });
    };

    return recordServices;

}]);
