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
			<th scope="col">Username</th>
			<th scope="col">Password</th>
			<th scope="col">Email</th>
			<th scope="col">Role</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items = "${users}" var = "user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.email}</td>
<%-- 				<c:forEach items = "${user.roles}" var = "userRole">
				<td>${userRole.roleName}</td>
				</c:forEach> --%>
				<td>${user.role}</td>
				<td><a href="/deleteuser?userId=${user.userId}" class = "btn btn-warning">Delete</a></td>
				<td><a href="/updateuser?userId=${user.userId}"  class = "btn btn-success">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</Table>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
  </body>
</html> 