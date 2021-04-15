angular.module('app',['ngRoute', 'ngAnimate', 'ngSanitize', 'errors', 'ui.bootstrap', 'bw.paging', 'recordServices'])
	.config(function ($locationProvider, $routeProvider) {
		$routeProvider
			.when('/main', {
				controller: 'recordController',
				templateUrl: '/views/main.html',
				controllerAs: 'mc'
			})
			.otherwise({
				redirectTo: '/main'
			});
	})
;
