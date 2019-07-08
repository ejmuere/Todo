<%@ include file = "common/navbar.jspf" %>
<html>
<head>
<title>Greatness</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                rel="stylesheet">
</head>
<body>

<div class =container>
<form method="post">
	
	<div class="form-group">
    <label>Description</label>
    <input name = "description" type="text" class="form-control">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" >
    <label class="form-check-label" >Did you do it?</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>