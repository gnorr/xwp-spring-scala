<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><t:insertAttribute name="title"/></title>
    <link href="lib/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="lib/bootstrap/2.3.2/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<body>
<t:insertAttribute name="content"/>
<script src="lib/jquery/1.9.0/jquery.js" type="text/javascript"></script>
<script src="lib/bootstrap/2.3.2/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>
