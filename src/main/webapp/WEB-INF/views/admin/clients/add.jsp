<%@include file="../../shared/header.jsp" %>

<script>
    document.title = "Add Client";
</script>
<h1>Add Client</h1>
<form name="client" method="post" action="${SITE_URL}/admin/clients/save">
    <div class="form-group">
        <label>Client Name</label>
        <input name="name" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Address</label>
        <input name="address" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <label>Contact No.</label>
        <input name="contact" type="text" required="required"/> 
    </div>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/clients" class="btn btn-danger">Cancel</a>
    </div>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>            
<%@include file="../../shared/footer.jsp" %>