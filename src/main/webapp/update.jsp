<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="update">

    <div class="form-group">
        <label for="proName">商品名称</label>
        <input type="hidden" value="${prod.pro_id}" name="pro_id">
        <input type="text" class="form-control" id="proName" placeholder="商品名称" name="pro_name" value="${prod.pro_name}">
    </div>
    <div class="form-group">
        <label for="proPrice">商品价格</label>
        <input type="number" class="form-control" id="proPrice" placeholder="商品价格" min="1.00" max="999999.00" name="proPrice" >
    </div>
    <div class="form-group">
        <label for="exampleInputFile">选择图片</label>
        <input type="file" id="exampleInputFile" name="file1">
        <p class="help-block">请选择图片</p>
    </div>
    <div class="form-group">
        <label>商品信息</label>
        <textarea placeholder="请输入详细信息" style="width: 100%" name="proDes"></textarea>
    </div>
    <div class="form-group">
        <label for="proStock">商品库存</label>
        <input type="number" class="form-control" id="proStock" placeholder="商品库存" min="0" max="9999" name="proStock">
    </div>
    <div class="form-group">
        <label for="proDate">上架日期</label>
        <input type="date" class="form-control" id="proDate" placeholder="上架日期" name="proDate">
    </div>
    <div class="form-group">
        <label for="proCateid">类别ID</label>
        <input type="number" class="form-control" id="proCateid" placeholder="类别ID" min="0" max="999" name="proCateid">
    </div>
    <div class="form-group">
        <label for="proFact">生产厂家</label>
        <input type="text" class="form-control" id="proFact" placeholder="生产厂家" name="proFact">
    </div>

    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
