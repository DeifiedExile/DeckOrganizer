
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Deck Organizer - Home</title>
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/styles.css">
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
  <link rel="icon" href="favicon.ico" type="image/x-icon">
  <script src="scripts.js"></script>
</head>
<body class="bodyHome">

  <%@include file="nav.html"%>
<%--  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">--%>
<%--    <a class="navbar-brand" href="index.html"><i>Deck Organizer</i></a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">--%>
<%--      <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--      <ul class="navbar-nav mr-auto">--%>
<%--        <li class="nav-item">--%>
<%--          <a class="dropdown-item" href="listDecks">Deck List</a>--%>
<%--        </li>--%>
<%--        <li class="nav-item dropdown" id="searchCollapse">--%>
<%--          <form method="get" action="search">--%>

<%--            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" value="Deck Search">Deck Search</button>--%>

<%--            </button>--%>
<%--            <div class="dropdown-menu">--%>
<%--              <input type="text" id="navSearchText" name="searchTerm" required/>--%>
<%--              <input type="submit" value="Search" id="navSearchSubmit" class="btn btn-secondary" />--%>
<%--            </div>--%>
<%--          </form>--%>
<%--        </li>--%>
<%--      </ul>--%>
<%--    </div>--%>
<%--  </nav>--%>
  <div id="divHomeIntro" class="container">
    <p>Welcome to my Deck Organizer!</p>
    <!--        <a href="DeckList.html" class="btn-lg">click</a>-->
  </div>
  <!--    <div id="divUploadForm" class="container">-->
  <!--        <form method="post" action="deckServ" id="formLoadDecks" enctype="multipart/form-data">-->
  <!--            <div class="form-group">-->
  <!--                <label for="inputCSV">Select a .CSV file to upload existing decks.</label>-->
  <!--                <input id="inputCSV" type="file" accept=".csv" name="inputCSVParam" class="form-control-file" required>-->
  <!--                <input type="submit" value="Upload">-->
  <!--&lt;!&ndash;                <a href="DeckList.html" class="btn-lg">click</a>&ndash;&gt;-->
  <!--            </div>-->

  <!--        </form>-->
  <!--    </div>-->

  <div>
    <form method="get" action="listDecks">
      <input type="submit" value="Deck List"/>
    </form>
    <!--        <form method="get" action="search">-->
    <!--            <input type="text" name="searchTerm"/><br>-->
    <!--            <input type="submit" value="Search">-->
    <!--        </form>-->

  </div>

</body>
</html>
