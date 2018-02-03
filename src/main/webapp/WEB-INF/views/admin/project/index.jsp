<%@include file="../../shared/header.jsp" %>

<script>
    document.title = "Project Dashboard";</script>
<div class="page-header">
    <h1>Projects Dashboard</h1>
</div>

<div class="pull-left container-fluid form-group">
    <label>Client</label>
    <select id="client-id" name="clients.id" required="required">
        <option value="0">Select Client</option>
        <c:forEach var="clients" items="${clients}">
            <option value="${clients.id}">${clients.name}</option>
        </c:forEach>
    </select>
</div>

<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/project/add" class="btn btn-primary">
            <span class ="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="container-fluid">
    <table class="table text-center" border ="2" id="project-table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Client</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Action</th>
        </tr>
    </table>
</div>    
<div id="empty-table" class="text-danger text-center" style="font-size: 20px"></div>
<script>
    $(document).ready(function () {
        $('#client-id').on('change', function () {
            var id = $('#client-id').val();
            $.ajax({
                url: '${SITE_URL}/admin/project/' + id,
                datatype: 'json',
                success: function (data) {
                    console.log("success");
                    console.log(data);
                    $('#project-table tr:not(:first)').remove();
                    $('#empty-table').empty();
                    $(data).each(function (i, data) {
                        $('<tr/>').appendTo($('#project-table'))
                                .append($('<td/>').text(data.id))
                                .append($('<td/>').text(data.name))
                                .append($('<td/>').text(data.description))
                                .append($('<td/>').text(data.clients.name))
                                .append($('<td/>').text(data.startDate))
                                .append($('<td/>').text(data.endDate))
                                .append($('<td/>').append('<a href="${SITE_URL}/admin/project/edit/' + data.id + '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"/></a> <a href="${SITE_URL}/admin/project/delete/' + data.id + '" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a><a href="" class="btn btn-info"><span class="glyphicon glyphicon-info-sign"/></a>'))
                                .css('background-color',data.status.color); 
                        
                    });  
                    if(id != 0){
                        $('#project-table th:nth-child(4)').hide();
                        $('#project-table td:nth-child(4)').hide();
                    }else{
                        $('#project-table th:nth-child(4)').show();
                    }
                    
                    if(data.length == 0){
                        $('#empty-table').text("No Project for Selected Client");
                    }
                },
                error: function (jqxhr, textStatus, errorMessage) {
                    console.log("error");
                    console.log(errorMessage);
                }
            });
        }).trigger('change');
    });
</script>

<%@include file="../../shared/footer.jsp" %>