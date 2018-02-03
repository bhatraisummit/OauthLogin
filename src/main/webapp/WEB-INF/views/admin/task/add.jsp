<%@include file="../../shared/header.jsp" %>

<script>
    document.title = "Add Task";
</script>
<h1>Add Task</h1>
<form name="task" method="post" action="${SITE_URL}/admin/task/save">
    <div class="form-group">
        <label>Task Name</label>
        <input name="name" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Select Project</label>
        <select name="project.id" required="required">
            <option value="">Select Project</option>
            <c:forEach var="project" items="${project}">
                <option value="${project.id}">${project.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>EndDate</label>
        <input name="endDate" type="date" required="required"/> 
    </div>
    <div class ="form-group">
        <input type="hidden"
	name="status.id"
	value="1"/>
    </div>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/task" class="btn btn-danger">Cancel</a>
    </div>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>            
<%@include file="../../shared/footer.jsp" %>