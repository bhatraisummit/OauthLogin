<%@include file="../../shared/header.jsp" %>

<script>
    document.title = "Add Skill";
</script>
<h1>Add Skill</h1>
<form name="skills" method="post" action="${SITE_URL}/admin/skills/save">
    <div class="form-group">
        <label>Skill</label>
        <input name="skill" type="text" required="required"/> 
    </div>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/skills" class="btn btn-danger">Cancel</a>
    </div>
</form>            
<%@include file="../../shared/footer.jsp" %>