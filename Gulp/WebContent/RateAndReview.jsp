<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate & Review</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">
</head>
<body>


<div class="container">
<nav class="navbar navbar-default">
      <div class="container">
	<div class="container">
		<div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Gulp!</a>
        </div>

      </div>
      </div>
    </nav>
    </br >
    <div class="panel panel-default">

  <div class="panel-body">
    		<table class="table table-striped">
    		
<thead>

			<tr>
				<th>Restaurant Name</th>
				<th>Restaurant Description</th>
			</tr>
</thead>
<tbody>
			<tr>
				<td>${gulprestaurants.gulpRestaurantsName}</td>
				<td>${gulprestaurants.gulpRestaurantsDescription}</td>
			</tr>
</tbody>
		</table>
	</div>
	</div>
		
		<form action = "login?action=rate" method= "POST">
  <div class="form-group">
  <div class="panel panel-default">
 <div class="panel-heading" style="font-weight: bold;">Rate Restaurant</div>
  <div class="panel-body">
  <input type = "hidden" value = "${gulprestaurants.gulpRestaurantsid}" name ="restID">
  
    <div class="dropdown">
  
  
  Rate Restaurant :<br>
 


   <select name = "rate">
   
<option value="1">1 (Poor)</option>
  <option value="2">2 (Okay)</option>
  <option value="3">3 (Moderate)</option>
  <option value="4">4 (Good)</option>
  <option value="5">5 (Excellent)</option>
 
   </select>  


</div>
  <button type="submit" class="btn btn-info">Rate</button>
  </div>
  </div>
  </div>
</form>
    		<form action = "login?action=review" method= "POST">
  <div class="form-group">
  <div class="panel panel-default">
 <div class="panel-heading" style="font-weight: bold;">Review Restaurant</div>
  <div class="panel-body">
      <input type = "hidden" value = "${gulprestaurants.gulpRestaurantsid}" name ="restID">
    <div class="form-group">
    
    <textarea type="review" name = "review" class="form-control" id="examplereveiw" placeholder="Write a Review (128 characters)" ></textarea>
  </div>
  <button type="submit" class="btn btn-info">Review</button>
  </div>
  </div>
  </div>
</form>
    </div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
</body>
</html>