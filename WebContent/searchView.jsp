<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>BIG KPC</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Poppins", sans-serif
}

body {
	font-size: 16px;
}

a { text-decoration:none }

.w3-half img {
	margin-bottom: -6px;
	margin-top: 16px;
	opacity: 0.8;
	cursor: pointer
}

.w3-half img:hover {
	opacity: 1
}

div.container {
	width: 40%;
	margin-left: 30%;
	margin-right: 30%;
	margin-bottom: 15%;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 20px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 20px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-kb3h {
	font-size: 16px;
	font-family: Verdana, Geneva, sans-serif !important;;
	background-color: #efefef;
	text-align: center;
	vertical-align: top;
	border-color: #c0c0c0;
}

.tg .tg-1twi {
	font-family: Verdana, Geneva, sans-serif !important;;
	background-color: #ffffff;
	text-align: center;
	vertical-align: top;
	border-color: #c0c0c0;
}
</style>
</head>
<body>
	<!-- !PAGE CONTENT! -->
	<div class="w3-main">
		<div style="height: 30px"></div>
		<div class="w3-container"
			style="margin-top: 80px; text-align: center;" id="showcase">
			<h1 class="w3-xxxlarge w3-text-indigo">
				<b>BIG KPC.</b>
			</h1>
		</div>
		<div style="height: 50px"></div>

		<div class="container">
			<!-- Header -->
			<select id="bus" required class="w3-border"
				style="width: 30%; font-size: 16px; height: 35px;">
				<option value="전체">전체</option>
				<option value="건강관리기술">건강관리기술</option>
				<option value="결제관련서비스">결제관련서비스</option>
				<option value="출판">출판</option>
				<option value="생명보험">생명보험</option>
				<option value="자동차">자동차</option>
			</select> <input class="w3-border" style="width: 69%; height: 35px;"
				type="text" id="cmp" required>
			<p>
				<button onclick="createTable(document.getElementById('bus').value, document.getElementById('cmp').value)"
				id="name" class="w3-button w3-padding-large w3-margin-bottom" style="width: 30%; float: right; background-color: #1F486E">
					<font color="ffffff" size:"20px">Search.</font>
				</button>
				<br> <br> <br> <br>
			<div id="tableView"></div>
		</div>
		<!-- End page content -->
	</div>
			<div style="height: 100px"  id="bottom_bar"></div>


	<!-- W3.CSS Container -->
		<div class="w3-light-grey w3-container w3-padding-32"
			style="margin-top: 75px;">
			<p class="w3-right"><font color="#8C8C8C" size="4px">
				BIG KPC By<a class="w3-hover-opacity"> 'Three K'</a></font>
			</p>
		</div>
	
	<script type="text/javascript">
     
      function createTable(bus, name){
    	  var xhttp = new XMLHttpRequest();
    	  
          xhttp.onreadystatechange = function() {
             if (this.readyState == 4 && this.status == 200) {
                 document.getElementById("tableView").innerHTML = this.responseText;
                 document.getElementById("bottom_bar").style ="height: 0px";
             }
          };
          xhttp.open("GET", "search.do?bus="+bus+"&name="+name, true);
          xhttp.send();
      }
   </script>
</body>
</html>