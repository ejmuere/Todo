<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file = "common/navbar.jspf" %>

<html>
  <head>
    <title>Application</title>
      <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                rel="stylesheet">
  </head>
  <body>
  <div class = container>
	<Table class="table table-striped table-dark">
		<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Description</th>
			<th scope="col">Date</th>
			<th scope="col">Status</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items = "${todos}" var = "todo">
			<tr>
				<td>${todo.id}</td>
				<td>${todo.description}</td>
				<td><fmt:formatDate type= "date"  value = "${todo.targetDate}"/></td>
				<td>${todo.done}</td>
				<td><a href="/deletetodos?todoId=${todo.id}" class = "btn btn-warning">Delete</a></td>
				<td><a href="/updatetodos?todoId=${todo.id}"  class = "btn btn-success">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</Table>
		<a href="/addtodos" class = "btn btn-primary">Add to do</a>
	
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
  </body>
</html> 