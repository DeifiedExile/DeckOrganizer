<%--
  Created by IntelliJ IDEA.
  User: Wolf
  Date: 9/12/2019
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>DeckOrganizer - DeckList</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <title>Decks</title>

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
    <div class="container text-center" id="divDeckList">
        decks:
        ${deckList}
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <a href="NewDeck.html" class="btn-secondary border rounded p-2" name="btnAddDeck">New Deck</a>
            </div>
        </div>

    </div>
    
</body>
</html>
