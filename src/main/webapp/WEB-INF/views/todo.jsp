<%--
  Created by IntelliJ IDEA.
  User: mourine
  Date: 8/1/20
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add a Todo</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class ="container">
<H1>Addd a Todo</H1>
<form:form method="post" commandName="todo">
    <fieldset class="form-group">
        <form:label path="desc">Description</form:label>
        <form:input path="desc" type="text"
        class ="form-control" required ="required"/>
        <form:errors path="desc" cssClass = "text-warning" />
    </fieldset>

    <input class="btn btn-success" type="submit" value="add">
</form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
