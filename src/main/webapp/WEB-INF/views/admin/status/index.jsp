<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Status Dashboard";
</script>
<div class="page-header">
    <h1>Status Dashboard</h1>
</div>
<div class="pull-right">
    <p>
        <a href="" class="btn btn-primary">
            <span class ="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="container-fluid">
    <table border="2" class="table text-center" id="status-table">
                <tr>
                    <th>Id</th>
                    <th>Status</th>
                    <th>Color</th>
                </tr>
                <c:forEach var="s" items="${status}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.status}</td>
                        <td>${s.color}</td>
                        
                    </tr>
                </c:forEach>
    </table>
</div>

<%@include file="../../shared/footer.jsp" %>