<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "common/navbar.jspf" %>
<html>
<head>
<title>Greatness</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                rel="stylesheet">
</head>
<body>
<div class =container>
<form:form action ="/updateuser" method="post" modelAttribute ="user">
	<form:hidden path="userId"/>
	<fieldset class = "form-group">
		<div class="form-group">
		<form:label  path="username">Username: </form:label>
		<form:input class="form-control" path = "username" required = "required"/>
		</div>
		<div class="form-group">
		<form:label  path="password">Password: </form:label>
		<form:input class="form-control" path = "password" required = "required"/>
		</div>
		<div class="form-group">
		<form:label  path="username">Email: </form:label>
		<form:input class="form-control" path = "email" required = "required"/>
		</div>
		<%-- <div class = "radio">
			    <form:checkbox class="form-check-input"  path = "role" value = "User"/> User
			    <form:checkbox class="form-check-input"  path = "role" value = "Admin"/> Admin
			    <form:checkbox class="form-check-input" path = "role" value = "Dev"/> Dev
        </div> --%>
        <div class="form-group">
		  <form:label path = "role">Select list:</form:label>
		  <form:select class="form-control" path = "role" id="sel1">
		    <form:option value="User" path = "role">User</form:option>
		    <form:option value ="Admin" path = "role">Admin</form:option>
		    <form:option value = "Dev" path = "role">Dev</form:option>
		  </form:select>
		</div>
		<form:button class = "btn btn-primary">Submit</form:button>
	</fieldset>
	</form:form>
	</div>

</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>