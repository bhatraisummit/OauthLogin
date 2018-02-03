<%@include file="../../shared/header.jsp" %>
<script>
    document.title ="Add Project";
</script>
<div class="page-header">
    <h1>Add Project</h1>
</div>
<form name="project" method="post" action="${SITE_URL}/admin/project/save">
    <div class="form-group">
        <label>Project Name</label>
        <input name="name" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Description</label>
        <textarea name="description" class="form-control" required="required" style="width: 200px; height: 100px"></textarea> 
    </div>
    <div class="form-group">
        <label>Client</label>
        <select name="clients.id" required="required">
            <option value="">Select Client</option>
            <c:forEach var="client" items="${clients}">
                <option value="${client.id}">${client.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>End Date</label>
        <input name="endDate" type="date" required="required"/> 
    </div>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/project" class="btn btn-danger">Cancel</a>
    </div>
    <input type="hidden"
	name="status.id"
	value="1"/>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>            
<%@include file="../../shared/footer.jsp" %>