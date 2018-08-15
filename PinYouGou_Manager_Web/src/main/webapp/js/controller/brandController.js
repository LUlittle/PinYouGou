app.controller('brandController', function ($scope, $controller, brandService) {

    $controller('baseController', {$scope: $scope});

    //读取列表数据 将数据绑定到表单中
    brandService.findAll().success(
        function (rsp) {
            $scope.list = rsp;
        }
    )

    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (rsp) {
                $scope.list = rsp.rows;
                $scope.paginationConf.totalItems = rsp.total;//更新总记录数
            }
        );
    }

    //保存和更新
    $scope.add = function () {
        var serviceObj;
        if ($scope.entity.id != null && $scope.entity.id != undefined) {
            serviceObj = brandService.update($scope.entity);
        } else {
            serviceObj = brandService.add($scope.entity);
        }

        serviceObj.success(
            function (rsp) {
                if (rsp.success) {
                    $scope.reloadList();
                } else {
                    alert(rsp.message);
                }
            }
        )
    }

    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (rsp) {
            $scope.entity = rsp;
        })
    }

    //定义一个记录删除框的数组
    $scope.selectIds = [];
    //更新复选
    $scope.updateSelection = function ($event, id) {
        //如果是选中则添加到数组中
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            //取消则从数组中删除 拿到该id在数组中的位置
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);
        }
    }

    //删除
    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(function (rsp) {
            if (rsp.success) {
                $scope.reloadList();
            } else {
                alert(rsp.message)
            }
        })
    }

    //条件查询 定义查询对象
    $scope.searchEntity = {};//定义搜索对象
    //条件查询
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }

})