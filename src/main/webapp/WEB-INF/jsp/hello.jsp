<%@ include file = "common/navbar.jspf" %>
<html>
  <head>
    <title></title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                rel="stylesheet">
  </head>
  <body>
  <div class =container>
	<div class="card">
  <div class="card-header">
    Featured
  </div>
  <div class="card-body">
    <h5 class="card-title">Hello this is you information</h5>
    <p class="card-text">Hello ${username}, Your password is ${password}</p>
    <a href="/listtodos" class="btn btn-primary">Click here</a>
  </div>
</div>
</div>
  </body>
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html> 