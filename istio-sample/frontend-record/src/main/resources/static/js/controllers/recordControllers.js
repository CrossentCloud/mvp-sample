'use strict';

angular.module('app')
	.controller('recordController', function ($scope, $location, recordServices) {
		var mc = this;
		$scope.loadingMain =false;
		mc.uploadProgress = false;
		mc.recordList = [];
		mc.inputData = '';

		mc.listData = function(){
			var results = recordServices.list();
			results.success(function (data) {
				mc.recordList = data;
			}).error(function () {
				mc.recordList = [];
			});
		};

		mc.insertData = function() {
			var results = recordServices.insert(mc.inputData);
			results.success(function (data) {
				mc.reset();
			}).error(function () {
				mc.reset();
			});
		};

		mc.reset = function() {
			mc.inputData = '';
			mc.listData();
		};

		mc.reset();
	})
;
