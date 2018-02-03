<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Edit Skill"
</script>
<div class="page-header">
    <h1>Edit Skill</h1>
</div>
<form name="skills" method="post" action="${SITE_URL}/admin/skills/save">
    <div class="form-group">
        <label>Skill</label>
        <input name="skill" type="text" value="${skills.skill}" required="required"/> 
    </div>   
    <input type="hidden" name="id" value="${skills.id}"/>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/skills" class="btn btn-danger">Cancel</a>
    </div>
</form>            
<%@include file="../../shared/footer.jsp" %>