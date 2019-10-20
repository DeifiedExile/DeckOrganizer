<%--
  Created by IntelliJ IDEA.
  User: Wolf
  Date: 9/14/2019
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeckOrganizer - DeckList</title>
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/styles.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>


    <title></title>
</head>
<body>
    <%@ include file="/nav.html" %>

    <div class="container">
        ${cardList}
    </div>
    
</body>
</html>
