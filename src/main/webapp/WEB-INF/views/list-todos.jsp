<%--
  Created by IntelliJ IDEA.
  User: mourine
  Date: 8/1/20
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file ="fragments/header.jspf"%>
<%@ include file ="fragments/navigation.jspf"%>
<div class ="container">
    <table class="table table-striped">
        <caption>Your Todos are</caption>

        <thead>
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Completed</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td>
                    <a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                    <a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Danger</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
<a class="btn btn-success" href="/add-todo">Add</a>
</div>
<%@ include file ="fragments/footer.jspf"%>

