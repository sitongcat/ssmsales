<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>销量列表</title>
    <%@include file="common/include.jsp" %>
    <style>

        #foot {

            text-align: right;
        }
    </style>
</head>
<body>



<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <br/>
            <div class="panel panel-default">
                <div class="panel-body">
                    <button type="button" onclick="preSave()" class="btn btn-default">添加</button>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>客户编码</th>
                        <th>客户名称</th>
                        <th>销售时间</th>
                        <th>销售品种</th>
                        <th>销售数量</th>
                        <th>销售价格</th>
                        <th>销售区域</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sales" items="${page.records}">
                        <tr>

                            <td>${sales.customer_id}</td>
                            <td>${sales.customer_name}</td>
                            <td>${sales.sales_date}</td>
                            <td>${sales.sales_oil}</td>
                            <td>${sales.sales_price}</td>
                            <td>${sales.sales_count}</td>
                            <td>${sales.customer_area}</td>
                            <td>
                                <a href="javascript:void(0);" onclick="preSave('${sales.id}')" title="编辑">
                                    <i class="glyphicon glyphicon-edit"></i>
                                </a>
                                <a href="javascript:void(0);" onclick="del('${sales.id}')" title="删除">
                                    <i class="glyphicon glyphicon-remove"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div id="foot">

                <tr>
                    <td colspan="5" align="right">
                        当前第 ${page.current}/${page.pages} 页, 共${page.total}条记录&nbsp;&nbsp;
                        <a href="javascript:void(0);" onclick="toPage(1);return false;">首页</a>
                        <a href="javascript:void(0);" onclick="toPage(${page.current - 1});return false;">上一页</a>
                        <a href="javascript:void(0);" onclick="toPage(${page.current + 1});return false;">下一页</a>
                        <a href="javascript:void(0);" onclick="toPage(${page.pages});return false;">尾页</a>
                    </td>
                </tr>


            </div>
            <form action="${ctx}/" id="pageForm" method="post">
                <input type="hidden" id="current" name="current" value=""/>
                <input type="hidden" id="pageSize" name="pageSize" value="${page.size}"/>
                <input type="hidden" id="pageTotal" value="${page.pages}"/>
            </form>
        </div>
    </div>
</div>
<script>
    function preSave(id) {
        if (id == undefined || id == null || id == '') {
            window.location.href = '${ctx}/preSaveSales';
        } else {
            window.location.href = '${ctx}/preSaveSales?id=' + id;
        }
    }

    function del(id) {
        $.ajax({
            type: 'POST',
            url: '${ctx}/deleteSales',
            data: {
                id: id
            },
            dataType: 'json',
            success: function (data) {
                alert(data.msg);
                if (data.success) {
                    setTimeout('toIndex()', 100);
                }
            },
            error: function () {
                alert("出错了,请重试!");
            }
        });
    }

    function toPage(n) {
        if (n <= 0) {
            n = 1;
        }
        if (n > $('#pageTotal').val()) {
            n = $('#pageTotal').val();
        }
        $('#current').val(n);

        $('#pageForm').submit();


    }

</script>
</body>
</html>
