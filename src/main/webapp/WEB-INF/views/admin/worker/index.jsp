<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Worker Dashboard";
</script>
<div class="page-header">
    <h1>Worker Dashboard</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/worker/add" class="btn btn-primary">
            <span class ="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="container-fluid">
    <table class="table text-center" id="client-table" border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contact No.</th>
            <th>Skill</th>
            <th>Action</th>
        </tr>
        <c:forEach var="w" items="${worker}">
            <tr>
                <td>${w.id}</td>
                <td>${w.name}</td>
                <td>${w.address}</td>
                <td>${w.contactNo}</td>
                <td>${w.skills.skill}</td>
                <td>
                <a href="${SITE_URL}/admin/worker/edit/${w.id}" class="btn btn-primary">
                    <span class="glyphicon glyphicon-pencil"/>
                </a>
                <a href="${SITE_URL}/admin/worker/delete/${w.id}" class="btn btn-danger">
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