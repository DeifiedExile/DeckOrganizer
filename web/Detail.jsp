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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-csv/1.0.5/jquery.csv.js"></script>--%>
    <script src="${pageContext.request.contextPath}/scripts.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://api.scryfall.com"></script>
    <title></title>
</head>
<body>
    <%@ include file="/nav.html" %>
<%--    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">--%>
<%--        <a class="navbar-brand" href="index.html"><i>Deck Organizer</i></a>--%>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <ul class="navbar-nav mr-auto">--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">--%>
<%--                        Menu--%>
<%--                    </a>--%>
<%--                    <div class="dropdown-menu">--%>
<%--                        <a class="dropdown-item" href="listDecks">Deck List</a>--%>
<%--                        <a class="dropdown-item" href="search">Deck Search</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </nav>--%>
    <div class="container">
        ${cardList}
    </div>
    
</body>
</html>
