<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户列表</title>
    <%@include file="../common/include.jsp" %>
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
                        <th>ID</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${page.records}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.ctime}</td>
                            <td>
                                <a href="javascript:void(0);" onclick="preSave('${user.id}')" title="编辑">
                                    <i class="glyphicon glyphicon-edit"></i>
                                </a>
                                <a href="javascript:void(0);" onclick="del('${user.id}')" title="删除">
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
            window.location.href = '${ctx}/preSave';
        } else {
            window.location.href = '${ctx}/preSave?id=' + id;
        }
    }

    function del(id) {
        $.ajax({
            type: 'POST',
            url: '${ctx}/delete',
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
