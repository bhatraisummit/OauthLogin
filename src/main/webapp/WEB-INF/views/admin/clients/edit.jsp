<%@include file="../../shared/header.jsp" %>
<script>
    document.title = "Edit Client";
</script>
<div class="page-header">
    <h1>Edit Client</h1>
</div>
<form name="client" method="post" action="${SITE_URL}/admin/clients/save">
    <div class="form-group">
        <label>Client Name</label>
        <input name="name" type="text" value="${clients.name}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Address</label>
        <input name="address" type="text" value="${clients.address}" required="required"/> 
    </div>
    <div class="form-group">
        <label>Contact No.</label>
        <input name="contact" type="text" value="${clients.contact}" required="required"/> 
    </div>
    <div>
        <input name="id" type="hidden" value="${clients.id}"/>
    </div>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <div class="form-group">
        <button type = "submit" class="btn btn-success">Submit</button>
        <a href="${SITE_URL}/admin/clients" class="btn btn-danger">Cancel</a>
    </div>
</form>            
<%@include file="../../shared/footer.jsp" %>