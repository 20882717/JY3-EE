<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/logp1.css">
    <link rel="stylesheet" href="css/logp2.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>

    <form action="logprod" method="post">
        <div class="wrapper">
            <div class="box">
                <div class="row row-offcanvas row-offcanvas-left">
                    <div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
                        <ul class="nav">
                            <li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
                        </ul>
                        <ul class="nav hidden-xs" id="lg-menu">
                            <li class="active"><a href="#featured"><i class="glyphicon glyphicon-list-alt"></i>  <a href="uponepord.jsp"><button type="button" class="btn btn-info" style="width: 100%">添加</button></a></a></li>

                        </ul>
                    </div>
                    <div class="column col-sm-10 col-xs-11" id="main">
                        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" ></a></div>
                        <table border="black 1px solid">
                            <thead>
                            <td>商品ID</td>
                            <td>商品名字</td>
                            <td>商品价格</td>
                            <td>商品图片</td>
                            <td>商品描述</td>
                            <td>商品库存</td>
                            <td>上架日期</td>
                            <td>商铺类别</td>
                            <td>生产厂家</td>
                            <td>操作</td>
                            </thead>
                            <c:forEach items="${prods}" var="prod">
                                <tr>
                                    <td>${prod.pro_id}</td>
                                    <td>${prod.pro_name}</td>
                                    <td>${prod.pro_price}</td>
                                    <td><img src="/imgs/${prod.pro_image}" style="width: 150px"></td>
                                    <td>${prod.pro_des}</td>
                                    <td>${prod.pro_stock}</td>
                                    <td>${prod.pro_date}</td>
                                    <td>${prod.pro_category_id}</td>
                                    <td>${prod.pro_factory}</td>
                                    <td>
                                        <a href="show?pro_id=${prod.pro_id}&pro_name=${prod.pro_name}&pro_price=${prod.pro_price}&pro_image=${prod.pro_image}&pro_des=${prod.pro_des}&pro_stock=${prod.pro_stock}&pro_date=${prod.pro_date}&pro_category_id=${prod.pro_category_id}&pro_factory=${prod.pro_factory}"><button type="button" class="btn btn-warning">修改</button></a>

                                        <a href="del?pro_id=${prod.pro_id}&pro_name=${prod.pro_name}&pro_price=${prod.pro_price}&pro_image=${prod.pro_image}&pro_des=${prod.pro_des}&pro_stock=${prod.pro_stock}&pro_date=${prod.pro_date}&pro_category_id=${prod.pro_category_id}&pro_factory=${prod.pro_factory}"><button type="button" class="btn btn-danger">删除</button></a>
                                    </td>
                                </tr>

                            </c:forEach>


                        </table>

                    </div>
                </div>
            </div>
        </div>
        <div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        Update Status
                    </div>
                    <div class="modal-body">
                        <form class="form center-block">
                            <div class="form-group">
                                <textarea class="form-control input-lg" autofocus="" placeholder="What do you want to share?"></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <div>
                            <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
                            <ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="js/logp1.js"></script>
    <script src="js/logp2.js"></script>
</body>
</html>
