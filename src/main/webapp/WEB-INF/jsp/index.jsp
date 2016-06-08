<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
    <meta charset="UTF-8"/>
    <title>批量导数据</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-2.1.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/angular.min.js"></script>
    <script src="/static/js/controller.js"></script>
    <style type="text/css">
        .head{
            margin-top: 15%;
        }
    </style>
</head>
<body>
    <div class="container"  ng-controller="control">
        <div class="head"></div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h2 class="panel-title">导数据啦</h2>
            </div>
            <div class="panel-body">
                <form action="excel" method="post" enctype="multipart/form-data" class="form-inline">
                    <button type="button" class="btn btn-primary" ng-click="add()">添加数据</button>
                    <br >
                    <div class="row" style="margin-top:10px;" ng-repeat="param in list">
                        <div class="form-group">
                            <label for="before">转换前</label>
                            <input type="text" class="form-control" id="before" placeholder="转换前数据" name="list[{{$index}}].before">
                        </div>
                        <div class="form-group">
                            <label for="after">转换后</label>
                            <input type="text" class="form-control" id="after" placeholder="转换后数据" name="list[{{$index}}].after">
                        </div>
                         <br>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile" name="file">
                        <p class="help-block">上传报表文件</p>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
            <div class="panel-footer">${data.msg}<br>
                ${data.reason}<br>${data.line}<br>${data.table}    </div>
        </div>
    </div>
</body>
</html>