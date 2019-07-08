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
<form:form action ="/updatetodos" method="post" modelAttribute ="todo">
	<form:hidden path="id"/>
	<fieldset class = "form-group">
		<div class="form-group">
		<form:label  path="description">Description: </form:label>
		<form:input class="form-control" path = "description" required = "required"/>
		</div>
	<%-- 	<div class="form-group">
		  <form:label path = "targetDate">Date and time</form:label>
		  <div class="col-10">
		    <form:input path = "targetDate" class="form-control" type="date"/>
        </div>
        </div>  --%>
		<div class="form-group">
		<form:checkbox class="form-check-input" path = "done"/> 
		<form:label class = "form-check-label" path="done">Is it Done? </form:label>
		</div>
		<div class="form-group">
		<form:errors class="alert alert-danger" path = "description"></form:errors>
		</div>
		<form:button class = "btn btn-success">Submit</form:button>
	</fieldset>
	</form:form>
	</div>
</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>