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
                    Materialize.toast('The page is added to the database', 3000, 'rounded');
                })
                .error(function () {
                    Materialize.toast('The page is not added!!!', 3000, '')
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
                    Materialize.toast('The page is update to the database', 3000, 'rounded');
                })
                .error(function () {
                    Materialize.toast('The page is not updated!!!', 3000, '')
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
                    Materialize.toast('The page is delete to the database', 3000, 'rounded');
                })
                .error(function () {
                    Materialize.toast('The page is not deleted!!!', 3000, '')
                });
        }
    }
});

// Image
myAdmin.controller('adminImageController', function ($scope, $http) {

    //Get list actual images
    $http.get('/admin/images')
        .success(function (data) {
            $scope.imagesDel = data;
            $scope.imagesPrev = data;
        })
        .error(function (data, status) {
            console.log("код ответа: " + status);
        });


    // POST: image -> click to button
    $scope.uploadFile = function (imgForm, imgRadio, imgFile) {
        if (imgForm.$valid && imgRadio.name == true) {
            var fd = new FormData();
            fd.append('file', imgFile);
            $http.post("/admin/createImage", fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
                .success(function () {
                    Materialize.toast('The image is added to the database', 3000, 'rounded');
                    //Get list actual images
                    $http.get('/admin/images')
                        .success(function (data) {
                            $scope.imagesDel = data;
                            $scope.imagesPrev = data;
                        })
                        .error(function (data, status) {
                            console.log("код ответа: " + status);
                        });
                })
                .error(function () {
                    Materialize.toast('The image is not added in the database!!!', 3000, '')
                });
            $scope.imgRadio.name = false;
        } else {
            Materialize.toast('Please upload image!!!', 3000, '')
        }
    };

    //DELETE IMAGE BY ID
    $scope.deleteImg = function (selectOptDel) {
        if (selectOptDel > 0) {
            $http.delete('/admin/deleteImage/' + selectOptDel)
                .success(function () {
                    Materialize.toast('Delete image id:' + selectOptDel, 3000, 'rounded');
                    //UPDATE ALL RESOURCE
                    // repeat: get list
                    $http.get('/admin/images')
                        .success(function (data) {
                            $scope.imagesDel = data;
                            $scope.imagesPrev = data;
                        });
                })
                .error(function () {
                    Materialize.toast('The image is not delete in the database!!!', 3500, '')
                });
        }
        else {
            Materialize.toast('Please select image!!!', 3000, '')
        }
    };

    //GET -> ID
    $scope.findImg = function (selectOptFind) {
        if (selectOptFind > 0) {
            $http.get('/admin/viewImage/' + selectOptFind).success(function (data) {
                $scope.imageViewId = data;
            });
        }
        else {
            Materialize.toast('Please select image!!!', 3000, '')
        }
    };

});

// Pattern
myAdmin.controller('adminCreatePatternController', function ($scope, $http) {
    $scope.patternType = ['BEHAVIORAL', 'CREATIONAL', 'STRUCTURAL'];

    //Get list available images
    $http.get('/admin/imagesPattern')
        .success(function (data) {
            $scope.imagesAvailable = data;
        })
        .error(function (data, status) {
            console.log("код ответа: " + status);
        });

    // POST: Create Pattern
    $scope.createPattern = function (patternCreateForm, pattern, imageTypePatternCreate) {
        if (patternCreateForm.$valid
            && pattern.text != ''
            && pattern.title != ''
            && imageTypePatternCreate.id > 0) {
            $http.post("/admin/createPattern",
                "id_image=" + imageTypePatternCreate.id +
                "&tag=" + pattern.tag +
                "&title=" + pattern.title +
                "&text=" + pattern.text,
                {
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                })
                .success(function () {
                    $scope.pattern.tag = '';
                    $scope.pattern.title = '';
                    $scope.pattern.text = '';
                    //Get list available images
                    $http.get('/admin/imagesPattern')
                        .success(function (data) {
                            $scope.imagesAvailable = data;
                        })
                        .error(function (data, status) {
                            console.log("код ответа: " + status);
                        });
                    Materialize.toast('The pattern is added to the database', 3000, 'rounded');
                })
                .error(function () {
                    Materialize.toast('The pattern is not added in the database!!!', 3000, '')
                });
        }
    };

});
myAdmin.controller('adminUpdatePatternController', function ($scope, $http) {
    $scope.patternsTagUpdate = ['BEHAVIORAL', 'CREATIONAL', 'STRUCTURAL'];
    $scope.patternsTagUpdateNew = ['BEHAVIORAL', 'CREATIONAL', 'STRUCTURAL'];

    //GET LIST PATTERN BY ID
    $scope.selectUpdatePattern = function (patternUpdate) {
        if (!angular.isUndefined(patternUpdate)) {
            //Get list patterns where Tag
            $http.get('/admin/getPatterns/' + patternUpdate.tag)
                .success(function (data) {
                    $scope.patternsTitleUpdate = data;
                    Materialize.toast('Get list pattern where type: ' + patternUpdate.tag, 3000, 'rounded');
                })
                .error(function (data, status) {
                    console.log("код ответа: " + status);
                });
        } else {
            Materialize.toast('Please select type!!!', 3000, '')
        }
    };

    //HIDE page content update
    $scope.hidePattern = true;

    //GET PATTERN BY ID
    $scope.getPattern = function (patternTitleUp) {
        if (!angular.isUndefined(patternTitleUp)) {
            $http.get('/admin/getPattern/' + patternTitleUp.id)
                .success(function (data) {
                    $scope.patternUpdateObject = data;
                    $scope.hidePattern = false;

                    //Get list available images
                    $http.get('/admin/imagesPattern')
                        .success(function (data) {
                            $scope.imagesAvailableNew = data;
                        })
                        .error(function (data, status) {
                            console.log("код ответа: " + status);
                        });

                })
                .error(function (data, status) {
                    console.log("код ответа: " + status);
                });
        }
    };

    //PARAM DEFAULT
    $scope.newRadioTag = false;
    $scope.newRadioImage = false;

    //UPDATE PATTERN
    $scope.updatePattern = function (patternUpdateObject,
                                     newRadioTag,
                                     newUpdatePatternTag,
                                     newRadioImage,
                                     newUpdatePatternImage) {
        //NEW TAG
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioTag == true
            && newRadioImage == false
            && !angular.isUndefined(newUpdatePatternTag)) {
            var _updatePatternNewTAg = {
                id: patternUpdateObject.id,
                tag: newUpdatePatternTag,
                title: patternUpdateObject.title,
                text: patternUpdateObject.text,
                image: patternUpdateObject.image
            };
            $http.post('/admin/updatePattern', _updatePatternNewTAg)
                .success(function () {
                    //HIDE page content update
                    $scope.hidePattern = true;
                    $scope.patternsTitleUpdate = '';
                    $scope.newRadioTag = false;
                    $scope.newRadioImage = false;
                    $scope.newUpdatePatternTag = '';
                    Materialize.toast('Pattern update in DataBase ID:' + patternUpdateObject.id, 3000, 'rounded');
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioTag == true
            && newRadioImage == false
            && angular.isUndefined(newUpdatePatternTag)) {
            Materialize.toast('Please select type pattern!!!', 3000, '')
        }

        //NEW IMAGE
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioImage == true
            && newRadioTag == false
            && !angular.isUndefined(newUpdatePatternImage)) {
            var _updatePatternNewImage = {
                id: patternUpdateObject.id,
                tag: patternUpdateObject.tag,
                title: patternUpdateObject.title,
                text: patternUpdateObject.text,
                image: newUpdatePatternImage.name
            };
            $http.post('/admin/updatePattern', _updatePatternNewImage)
                .success(function () {
                    //HIDE page content update
                    $scope.hidePattern = true;
                    $scope.patternsTitleUpdate = '';
                    $scope.newRadioTag = false;
                    $scope.newRadioImage = false;
                    $scope.newUpdatePatternTag = '';
                    Materialize.toast('Pattern update in DataBase ID:' + patternUpdateObject.id, 3000, 'rounded');
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioImage == true
            && newRadioTag == false
            && angular.isUndefined(newUpdatePatternImage)) {
            Materialize.toast('Please select image pattern!!!', 3000, '')
        }

        //NEW IMAGE AND TAG
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioImage == true
            && !angular.isUndefined(newUpdatePatternTag)
            && newRadioTag == true
            && !angular.isUndefined(newUpdatePatternImage)) {
            var _updatePatternNewTagAndImage = {
                id: patternUpdateObject.id,
                tag: newUpdatePatternTag,
                title: patternUpdateObject.title,
                text: patternUpdateObject.text,
                image: newUpdatePatternImage.name
            };
            $http.post('/admin/updatePattern', _updatePatternNewTagAndImage)
                .success(function () {
                    //HIDE page content update
                    $scope.hidePattern = true;
                    $scope.patternsTitleUpdate = '';
                    $scope.newRadioTag = false;
                    $scope.newRadioImage = false;
                    $scope.newUpdatePatternTag = '';
                    Materialize.toast('Pattern update in DataBase ID:' + patternUpdateObject.id, 3000, 'rounded');
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioImage == true
            && newRadioTag == true) {
            if (angular.isUndefined(newUpdatePatternTag)) {
                Materialize.toast('Please select type pattern!!!', 3000, '')
            }
            if (angular.isUndefined(newUpdatePatternImage)) {
                Materialize.toast('Please select image pattern!!!', 3000, '')
            }
        }

        //DEFAULT
        if (!angular.isUndefined(patternUpdateObject)
            && newRadioTag == false
            && newRadioImage == false) {
            var _updatePattern = {
                id: patternUpdateObject.id,
                tag: patternUpdateObject.tag,
                title: patternUpdateObject.title,
                text: patternUpdateObject.text,
                image: patternUpdateObject.image
            };
            $http.post('/admin/updatePattern', _updatePattern)
                .success(function () {
                    //HIDE page content update
                    $scope.hidePattern = true;
                    $scope.patternsTitleUpdate = '';
                    Materialize.toast('Pattern update in DataBase ID:' + patternUpdateObject.id, 3000, 'rounded');
                })
                .error(function (status) {
                    console.log("код ответа: " + status);
                });
        }
    }
});

myAdmin.controller('adminDeletePatternController', function ($scope, $http) {
    $scope.patternsTagDelete = ['BEHAVIORAL', 'CREATIONAL', 'STRUCTURAL'];

    //GET LIST PATTERN BY TAG
    $scope.selectDeletePattern = function (patternDelete) {
        if (!angular.isUndefined(patternDelete)) {
            //Get list patterns where Tag
            $http.get('/admin/getPatterns/' + patternDelete.tag)
                .success(function (data) {
                    $scope.patternsTitleDelete = data;
                    Materialize.toast('Get list pattern where type: ' + patternDelete.tag, 3000, 'rounded');
                })
                .error(function (data, status) {
                    console.log("код ответа: " + status);
                });
        } else {
            Materialize.toast('Please select type!!!', 3000, '')
        }
    };

    //DELETE PATTERN -> id
    $scope.deletePattern = function (patternDeleteForm, patternTitleDl, patternDelete) {
        if (patternDeleteForm.$valid
            && !angular.isUndefined(patternTitleDl)) {
            $http.delete('/admin/deletePattern/' + patternTitleDl.id)
                .success(function () {
                    //Get list patterns where Tag
                    $http.get('/admin/getPatterns/' + patternDelete.tag)
                        .success(function (data) {
                            $scope.patternsTitleDelete = data;
                        })
                        .error(function (data, status) {
                            console.log("код ответа: " + status);
                        });

                    Materialize.toast('Delete pattern ID:' + patternTitleDl.id, 3000, 'rounded');
                })
                .error(function (data, status) {
                    console.log("код ответа: " + status);
                });

        } else {
            Materialize.toast('Please select title!!!', 3000, '')
        }
    }
});

