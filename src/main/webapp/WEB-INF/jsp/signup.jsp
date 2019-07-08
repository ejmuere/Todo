<%@ include file = "common/navbar.jspf" %>
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
    <label>Username</label>
    <input type="text" class="form-control" placeholder="Username" name="username" required = "required">
  </div>
  <div class="form-group">
    <label>Password</label>
    <input type="password" class="form-control"placeholder="Password" name="password" required = "required">
  </div>
  <div class="form-group">
    <label>Email</label>
    <input type="text" class="form-control" placeholder="Email" name="email" required = "required">
  </div>
  <div class="form-group">
  <p class="text-danger">${errorMessage}</p>
  </div>
  <button type="submit" class="btn btn-primary">Sign Up</button>
</form>
</div>

</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>