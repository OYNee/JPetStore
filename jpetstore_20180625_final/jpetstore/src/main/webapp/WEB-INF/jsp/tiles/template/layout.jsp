<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<!--<title>JPetStore Demo</title>-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Cache-Control" content="max-age=0">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<link rel="stylesheet" href="../style/petstore.css" type="text/css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="../petstore.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" ignore="true"/>
	<tiles:insertAttribute name="body" ignore="true"/>
	<tiles:insertAttribute name="banner" ignore="true"/>
	<tiles:insertAttribute name="footer" ignore="true"/>
</body>
</html>
