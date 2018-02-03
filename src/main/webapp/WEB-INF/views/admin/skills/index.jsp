<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Skill Dashboard";
</script>
<div class="page-header">
    <h1>Skill Dashboard</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/skills/add" class="btn btn-primary">
            <span class ="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="container-fluid">
    <table class="table text-center" id="client-table" border="2">
        <tr>
            <th>Id</th>
            <th>Skill</th>
            <th>Action</th>
        </tr>
        <c:forEach var="s" items="${skills}">
            <tr>
                <td>${s.id}</td>
                <td>${s.skill}</td>
                <td>
                <a href="${SITE_URL}/admin/skills/edit/${s.id}" class="btn btn-primary">
                    <span class="glyphicon glyphicon-pencil"/>
                </a>
                <a href="${SITE_URL}/admin/skills/delete/${s.id}" class="btn btn-danger">
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