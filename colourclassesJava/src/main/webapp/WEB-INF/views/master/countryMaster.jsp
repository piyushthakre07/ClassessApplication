<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<sec:authentication property="principal" var="principal" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="../resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/jsgrid/demos/demos.css" />

<link rel="stylesheet" type="text/css"
	href="../resources/jsgrid/css/jsgrid.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/jsgrid/css/theme.css" />
<!-- GOOGLE FONTS-->
<link href='../resources/jsgrid/jquery-ui.css' rel='stylesheet'
	type='text/css' />
<link
	href="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script src="../resources/jsgrid/jsgrid.core.js"></script>
<script src="../resources/jsgrid/jsgrid.load-indicator.js"></script>
<script src="../resources/jsgrid/jsgrid.load-strategies.js"></script>
<script src="../resources/jsgrid/jsgrid.sort-strategies.js"></script>
<script src="../resources/jsgrid/jsgrid.field.js"></script>
<script src="../resources/jsgrid/fields/jsgrid.field.text.js"></script>
<script src="../resources/jsgrid/fields/jsgrid.field.number.js"></script>
<script src="../resources/jsgrid/fields/jsgrid.field.select.js"></script>
<script src="../resources/jsgrid/fields/jsgrid.field.checkbox.js"></script>
<script src="../resources/jsgrid/fields/jsgrid.field.control.js"></script>
<style>
tfoot {
	display: table-header-group;
}

tfoot>tr>th>input {
	max-width: 87px;
}
</style>
<title>Country Master</title>
<script>
$(document).ready(function () {
	$("#countrydriverTableContainer").jsGrid({
	       width: "100%",
	       //height: "600px",
	       
	       filtering: true,
	       editing: true,
	       sorting: true,
	       paging: true,
	       autoload: true,
	       inserting: true,

	       pageSize: 10,
	       pageButtonCount: 10,
	       
	       controller: {
	           loadData: function(filter) {
	           	var d = $.Deferred();
	               $.ajax({
	                   type: 'GET',
	                   url: '/colourclassesJava/master/displayAllCountry',
	                   dataType: "json",
	                   success: function (data) {
	             
	                   	var data1 = $.grep(data, function(data) {
                            return (!filter.countryId || (data.countryId+'').indexOf(filter.countryId) > -1)
                           	&& (!filter.countryName || (data.countryName+'').toUpperCase().indexOf(filter.countryName.toUpperCase()) > -1)
                           	&& (!filter.active || (data.active+'').toUpperCase().indexOf(filter.active.toUpperCase()) > -1)
                           	&& (!filter.isdefault || (data.isdefault+'').toUpperCase().indexOf(filter.isdefault.toUpperCase()) > -1)
                             });  
	                   	d.resolve(data1); 
	                   },
	                   error: function(e) {
	                       alert("error: " + e.responseText);
	                   }
	               });
	               return d.promise();
	           },
	         insertItem: function(insertingClient) {
	    	       $.ajax({
	    	                   type: 'POST',
	    	                   url: '/colourclassesJava/master/insertCountry',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   data: JSON.stringify(insertingClient),
	    	                   success: function (data) {
	    	                   	alert("insertion done successfully");
	    	                	window.location.reload();
	    	                   }
	    	   	});
	    	   },

	    	   updateItem: function(updatingClient) {
	    	   	$.ajax({
	    	                   type: 'POST',
	    	                   url: '/colourclassesJava/master/updateCountry',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   data: JSON.stringify(updatingClient),
	    	                   success: function (data) {
	    	                   	alert("updation done successfully");
	    	                	window.location.reload();
	    	                   }
	    	   	});  
	    	   },

	    	   deleteItem: function(deletingClient) {
	    	   	$.ajax({
	    	                   type: 'POST',
	    	                   url: '/colourclassesJava/master/deleteCountry',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   data: JSON.stringify(deletingClient),
	    	                   success: function (data) {
	    	                   	alert("deletion done successfully");
	    	                	window.location.reload();
	    	                   }
	    	   	});  
	    	   }
	       },
	      
	     	fields: [
				  { name: "countryId", type: "number",    width:50, title: "Country Id" },
		        	{ name: "countryName", type: "text",    width:250, title: "country Name" },
		            { name: "active", type: "text", width:150,  title: "active"},
		           { name: "isdefault", type: "text",  width:150, title: "isdefault"},
		           { type: "control" }
		       ]
			       });
}); 
</script>
</head>
<body>
	<div class="clearfix"></div>
	<div id="content">
		<div class="container">
			<div class="row">
				<div class="col-lg-12"></div>
			</div>
			<hr />
			<div style="text-align: center;">
				<div id="countrydriverTableContainer"></div>
			</div>
		</div>
	</div>
</body>
</html>
