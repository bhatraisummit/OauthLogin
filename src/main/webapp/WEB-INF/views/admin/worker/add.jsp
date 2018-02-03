<%@include file="../../shared/header.jsp" %>

<script>
    document.title = "Add Worker";
</script>
<h1>Add Worker</h1>
<form name="client" method="post" action="${SITE_URL}/admin/worker/save">
    <div class="form-group">
        <label>Name</label>
        <input name="name" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Address</label>
        <input name="address" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Contact No.</label>
        <input name="contactNo" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Select Skill</label>
        <select name="skills.id" required="required">
            <option value="">Select Skill</option>
            <c:forEach var="s" items="${skills}">
                <option value="${s.id}">${s.skill}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/worker" class="btn btn-danger">Cancel</a>
    </div>
    
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>            
<%@include file="../../shared/footer.jsp" %>