<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Task Dashboard";
</script>
<div class="page-header">
    <h1>Task Dashboard</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/task/add" class="btn btn-primary">
            <span class ="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="container-fluid">
    <table class="table text-center" id="client-table" border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Project</th>
            <th>Action</th>
        </tr>
        <c:forEach var="t" items="${task}">
            <tr style="background-color:${t.status.color}">
                <td>${t.id}</td>
                <td>${t.name}</td>
                <td>${t.startDate}</td>
                <td>${t.endDate}</td>
                <td>${t.project.name}</td>
                <td>
                <a href="${SITE_URL}/admin/task/edit/${t.id}" class="btn btn-primary">
                    <span class="glyphicon glyphicon-pencil"/>
                </a>
                <a href="${SITE_URL}/admin/task/delete/${t.id}" class="btn btn-danger">
                    <span class="glyphicon glyphicon-trash"/>
                </a>
                <a href="." class="btn btn-info">
                    <span class="glyphicon glyphicon-info-sign"/>
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../../shared/footer.jsp" %>