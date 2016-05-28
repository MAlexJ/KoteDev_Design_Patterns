'use strict';

var myApp = angular.module('myApp', ['ngCookies']);


var myAdmin = angular.module('myAdmin', ["ngRoute"]).config(function ($routeProvider) {

    $(document).ready(function() {
        Materialize.updateTextFields();
    });

    $(".button-collapse").sideNav();

    $(document).ready(function(){
        // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal-trigger').leanModal();
    });


    $(document).ready(function() {
        $('input#text, textarea#textarea').characterCounter();
    });



    // ************  Home Page  ******************
    $routeProvider.when('/home',
        {
            templateUrl: './admin/adminHome.html',
            controller: 'adminHomeController'
        });

    // ************  Pages Page  ******************
    $routeProvider.when('/viewUsers',
        {
            templateUrl: './admin/viewUsers.html',
            controller: 'adminUsersController'
        });
    
    // ************  Pages Page  ******************
    $routeProvider.when('/createPage',
        {
            templateUrl: './admin/createPage.html',
            controller: 'adminCreatePageController'
        });

    $routeProvider.when('/updatePage',
        {
            templateUrl: './admin/updatePage.html',
            controller: 'adminUpdatePageController'
        });

    $routeProvider.when('/deletePage',
        {
            templateUrl: './admin/deletePage.html',
            controller: 'adminDeletePageController'
        });

    // ************  Image Page  ******************
    $routeProvider.when('/image',
        {
            templateUrl: './admin/image.html',
            controller: 'adminImageController'
        });
    
    // ************  Patterns Page  ******************
    $routeProvider.when('/createPattern',
        {
            templateUrl: './admin/createPattern.html',
            controller: 'adminCreatePatternController'
        });

    $routeProvider.when('/updatePattern',
        {
            templateUrl: './admin/updatePattern.html',
            controller: 'adminUpdatePatternController'
        });

    $routeProvider.when('/deletePattern',
        {
            templateUrl: './admin/deletePattern.html',
            controller: 'adminDeletePatternController'
        });
    

    // ************  Default Page  ******************
    $routeProvider.otherwise({redirectTo: '/home'});
});


