<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Client Dashboard";
</script>
<div class="page-header">
    <h1>Client Dashboard</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/clients/add" class="btn btn-primary">
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
            <th>Action</th>
        </tr>
        <c:forEach var="c" items="${clients}">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.address}</td>
                <td>${c.contact}</td>
                <td>
                <a href="${SITE_URL}/admin/clients/edit/${c.id}" class="btn btn-primary">
                    <span class="glyphicon glyphicon-pencil"/>
                </a>
                <a href="${SITE_URL}/admin/clients/delete/${c.id}" class="btn btn-danger">
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