<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Edit Project";
</script>
<div class="page-header">
    <h1>Edit Project</h1>
</div>
<form name="project" method="post" action="${SITE_URL}/admin/project/save">
    <div class="form-group">
        <label>Project Name</label>
        <input name="name" type="text" value="${project.name}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Description</label>
        <textarea name="description" class="form-control" required="required" style="width: 200px; height: 100px">${project.description}</textarea> 
    </div>
    <div class="form-group">
        <label>Client</label>
        <select name="clients.id" required="required">
            <option value="${project.clients.id}">${project.clients.name}</option>
            <c:forEach var="client" items="${clients}">
                <option value="${client.id}">${client.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Status</label>
        <select name="status.id" required="required">
            <option value="${project.status.id}">${project.status.status}</option>
            <c:forEach var="status" items="${status}">
                <option value="${status.id}">${status.status}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>End Date</label>
        <input name="endDate" type="date" value="${project.endDate}" required="required"/> 
    </div>
    <div>
        <input name="id" type="hidden" value="${project.id}"/>
    </div>
    
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/project" class="btn btn-danger">Cancel</a>
    </div>
    <input type="hidden"
	name="startDate"
	value="${project.startDate}"/>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>
<%@include file="../../shared/footer.jsp" %>