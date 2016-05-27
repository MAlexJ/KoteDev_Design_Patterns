'use strict';

// Home
myAdmin.controller('adminHomeController', function ($scope, $http) {
});

// Users
myAdmin.controller('adminUsersController', function ($scope, $http) {

    // GET: list users -> request get
    $http.get('/admin/getUsers').success(function (data) {
        $scope.viewUsers = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // selectUser(viewUser)
    $scope.selectUser = function (viewUser) {
        if (viewUser.id > 0) {
            $http.get('/admin/getUser/' + viewUser.id)
                .success(function (data) {
                    $scope.actualUser = data;
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
    }
});

// Page
myAdmin.controller('adminCreatePageController', function ($scope, $http) {

    // GET: list page typ -> request get
    $http.get('/admin/pageGetType').success(function (data) {
        $scope.pagesTypeCreate = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // POST: Create PAge
    $scope.createPage = function (pageCreateForm, pageCreate) {
        if (pageCreateForm.$valid && pageCreate.text != '') {
            var _create = {
                type: pageCreate.type,
                text: pageCreate.text
            };
            $http.post('/admin/createPage', _create)
                .success(function () {
                    pageCreate.text = '';
                    pageCreate.type = '';
                    $http.get('/admin/pageGetType').success(function (data) {
                        $scope.pagesTypeCreate = data;
                    });
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }

    };
});

myAdmin.controller('adminUpdatePageController', function ($scope, $http) {
    // GET: list page typ -> request get
    $http.get('/admin/updatePages').success(function (data) {
        $scope.pagesTypeUpdate = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    $scope.selectUpdatePage = function (pageTypeUpd) {
        if (pageTypeUpd.id > 0) {
            $http.get('/admin/updateGetPage/' + pageTypeUpd.id)
                .success(function (data) {
                    $scope.pagesTextUpdate = data;
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
    };

    $scope.updateUpdatePage = function (pageUpdateForm, pagesTextUpdate) {
        if (pageUpdateForm.$valid) {

            var _update = {
                id: pagesTextUpdate.id,
                text: pagesTextUpdate.text,
                type: pagesTextUpdate.type
            };

            $http.post('/admin/updatePage', _update)
                .success(function () {
                    $http.get('/admin/updatePages').success(function (data) {
                        $scope.pagesTypeUpdate = data;
                    });
                    $scope.pagesTextUpdate.text = '';
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
    }
});

myAdmin.controller('adminDeletePageController', function ($scope, $http) {
    // GET: list page typ -> request get
    $http.get('/admin/deletePages').success(function (data) {
        $scope.pagesTypeDelete = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // DELETE: list page typ -> request get
    $scope.deletePage = function (pageDeleteForm, pageTypeDel) {
        if (pageDeleteForm.$valid && pageTypeDel.id > 0) {
            $http.delete('/admin/deletePage/' + pageTypeDel.id)
                .success(function () {
                    $http.get('/admin/deletePages').success(function (data) {
                        $scope.pagesTypeDelete = data;
                    });
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
    }
});

// Pattern
myAdmin.controller('adminCreatePatternController', function ($scope, $http) {
});
myAdmin.controller('adminUpdatePatternController', function ($scope, $http) {
});
myAdmin.controller('adminDeletePatternController', function ($scope, $http) {
});

