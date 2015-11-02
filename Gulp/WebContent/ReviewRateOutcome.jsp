<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<th>Average Rating</th>
			</tr>
</thead>
<tbody>
			<tr>
				<td>${gulprestaurants.gulpRestaurantsName}</td>
				<td>${gulprestaurants.gulpRestaurantsDescription}</td>
				<td>${restaurantReview.avgRate}</td>
			</tr>
</tbody>
		</table>
	</div>
	</div>
	
  <div class="form-group">
  <div class="panel panel-default">
 <div class="panel-heading" style="font-weight: bold;">Reviews of Restaurant</div>
  <div class="panel-body">
  <table class= "table table-striped">
  <thead>
  <th>Date</th>
  <th>Review</th>
  </thead>
  <tbody>
  <c:forEach var="review" items="${restaurantReview.reviews}">
  <tr>
  <td>${review.reviewDate}</td>
  <td>${review.review}</td>
  </tr>
  </c:forEach>
  </tbody>
  
  </table>
  
  </div>
  </div>
</div>
</body>
</html>