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
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/styles.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>
    <title>Decks</title>

</head>
<body>
    <%@include file="../../nav.html"%>

    <div class="container text-center" id="divDeckList">
        decks:
        ${deckList}
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <a href="../../NewDeck.html" class="btn-secondary border rounded p-2" name="btnAddDeck">New Deck</a>
            </div>
        </div>

    </div>
    
</body>
</html>
