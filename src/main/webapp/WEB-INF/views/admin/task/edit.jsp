<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Edit Task";
</script>
<div class="page-header">
    <h1>Edit Task</h1>
</div>
<form name="task" method="post" action="${SITE_URL}/admin/task/save">
    <div class="form-group">
        <label>Task Name</label>
        <input name="name" type="text" value="${task.name}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Project</label>
        <select name="project.id" required="required">
            <option value="${task.project.id}">${task.project.name}</option>
            <c:forEach var="p" items="${project}">
                <option value="${p.id}">${p.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Status</label>
        <select name="status.id" required="required">
            <option value="${task.status.id}">${task.status.status}</option>
            <c:forEach var="status" items="${status}">
                <option value="${status.id}">${status.status}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>End Date</label>
        <input name="endDate" type="date" value="${task.endDate}" required="required"/> 
    </div>
    <div>
        <input name="id" type="hidden" value="${task.id}"/>
        <input name="startDate" type="hidden" value="${task.startDate}"/>
    </div>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/task" class="btn btn-danger">Cancel</a>
    </div>
</form>            
<%@include file="../../shared/footer.jsp" %>