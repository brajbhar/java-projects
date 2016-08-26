<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet" href="style/app.css">
</head>
<body ng-app="cyberom">
<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CyberOM</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#/home">Home</a></li>
            <li><a href="#/aboutus">About</a></li>
            <li><a href="#/contactus">Contact</a></li>
          </ul>
		  <div class="pull-right" style="padding-top: 6px;">
			  <ul class="list-inline" class="nav">
	        	<li><a ng-href="#/signup" class="btn btn-success">Sign up</a></li>
	        	<li><a href="" class="btn btn-default">Sign in</a></li>
	          </ul>
        </div>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<br><br><br>
<div ng-view class="container">
	
</div>


      <footer id="footer" class="container footer">
      	<div class="container text-center">
        <p>&copy; Company 2014</p>
        </div>
      </footer>
</body>
</html>