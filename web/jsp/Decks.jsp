<%--
  Created by IntelliJ IDEA.
  User: Wolf
  Date: 9/12/2019
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>DeckOrganizer - DeckList</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/styles.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-csv/1.0.5/jquery.csv.js"></script>
    <script src="../scripts.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <title>Decks</title>

</head>
<body>
    <div class="container text-center" id="divDeckList">
        request.getAttribute("deckList")


    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <a href="../NewDeck.html" class="btn-secondary border rounded p-2" name="btnAddDeck">New Deck</a>
            </div>
        </div>

    </div>
    
</body>
</html>
