<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tags/tags.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../common/header.jsp"/>

    <!--dynamic table-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/data-tables/DT_bootstrap.css"/>

    <script type="text/javascript">
        function edit(id) {
            top.showModal({
                url: "${pageContext.request.contextPath}/template/edit.do?id=" + (id ? id : ""),
                title: "模板 - 添加",
                opener: window,
                width: 800,
                height: 550
            });
        }
        function del(id) {
            window.location.href = "${pageContext.request.contextPath}/role/remove.do?id=" + id;
        }
    </script>
</head>

<body class="body">

<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <form class="form-inline" action="${pageContext.request.contextPath}/template/list.do" role="form"
                  method="post">
                <div class="adv-table">
                    <div class="row-fluid">
                        <div class="span3">
                            <div id="dynamic-table_length" class="dataTables_length">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="filter_LIKES_templateName"
                                           value="${filter_LIKES_templateName}" placeholder="请输入模板名称">
                                </div>
                                <button type="button" onclick="submitSearch()" class="btn btn-success"><i class="fa fa-search"></i>搜索</button>
                            </div>
                        </div>
                        <div class="span3">
                            <div class="dataTables_filter" id="dynamic-table_filter">
                                <a href="javascript:edit()"
                                   class="btn btn-success">添加</a>
                            </div>
                        </div>
                    </div>

                    <table class="display table table-bordered" id="dynamic-table">
                        <thead>
                        <tr>
                            <th width="15%">模板名称</th>
                            <th width="15%">模板分类</th>
                            <th width="15%">模板排序</th>
                            <th width="15%">模板描述</th>
                            <th width="15%">修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${entitys}" var="item">
                            <tr class="gradeU">
                                <td>${item.templateName}</td>
                                <td>${item.categoryId}</td>
                                <td>${item.sort}</td>
                                <td>${item.remark}</td>
                                <td>${item.updateDate}</td>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-default btn-xs"
                                           href="javascript:edit('${item.id}')">编辑</a>
                                        <a class="btn btn-default btn-xs"
                                           href="javascript:listRemove('${pageContext.request.contextPath}/template/remove.do?id=${item.id}')">删除</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </form>
        </section>
    </div>
</div>

</body>
</html>
