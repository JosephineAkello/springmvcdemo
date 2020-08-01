<%--
  Created by IntelliJ IDEA.
  User: mourine
  Date: 8/1/20
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigation.jspf"%>
<div class="container">
    <form:form method="post" commandName="todo">
        <form:hidden path="id" />
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control"
                        required="required" />
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" class="form-control"
                        required="required" />
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>
        <button type="submit" class="btn btn-success">Submit</button>
    </form:form>
</div>

<%@ include file="fragments/footer.jspf"%>

<script>
    $('#targetDate').datepicker({
                                    format : 'dd/mm/yyyy'
                                });
</script>

