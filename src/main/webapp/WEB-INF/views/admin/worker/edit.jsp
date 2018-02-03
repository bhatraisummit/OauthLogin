<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Edit Worker";
</script>
<div class="page-header">
    <h1>Edit Worker</h1>
</div>
<form name="worker" method="post" action="${SITE_URL}/admin/worker/save">
    <div class="form-group">
        <label>Client Name</label>
        <input name="name" type="text" value="${worker.name}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Address</label>
        <input name="address" type="text" value="${worker.address}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Contact No.</label>
        <input name="contactNo" type="text" value="${worker.contactNo}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Select Skill</label>
        <select name="skills.id" required="required">
            <option value="${worker.skills.id}">${worker.skills.skill}</option>
            <c:forEach var="s" items="${skills}">
                <option value="${s.id}">${s.skill}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <input name="id" type="hidden" value="${worker.id}"/>
    </div>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/worker" class="btn btn-danger">Cancel</a>
    </div>
</form>            
<%@include file="../../shared/footer.jsp" %>