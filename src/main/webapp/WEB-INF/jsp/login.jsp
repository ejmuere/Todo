<%@ include file = "common/navbar.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Greatness</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                rel="stylesheet">
</head>

<body>
<div class =container>
<form method = post >
  <div class="form-group">
    <label for="exampleDropdownFormEmail2">Username</label>
    <input type="text" class="form-control" id="exampleDropdownFormEmail2" placeholder="Username" name="username">
  </div>
  <div class="form-group">
    <label for="exampleDropdownFormPassword2">Password</label>
    <input type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password" name="password">
  </div>
  <div class="form-group">
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="dropdownCheck2">
      <label class="form-check-label" for="dropdownCheck2">
        Remember me
      </label>
    </div>
    <div class="form-group">
    <c:if test="${param.error != null}"> 
    	<p class="text-danger">Wrong Username or password try again</p>
	</c:if>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
  
</form>
</div>

</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>