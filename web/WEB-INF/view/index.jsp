
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Deck Organizer - Home</title>
  <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="resources/css/styles.css">
  <link rel="shortcut icon" href="resources/img/favicon.ico" type="image/x-icon">
  <link rel="icon" href="resources/img/favicon.ico" type="image/x-icon">
  <script src="resources/js/scripts.js"></script>
</head>
<body class="bodyHome">

  <%@include file="../../nav.html"%>

  <div id="divHomeIntro" class="container">
    <p>Welcome to my Deck Organizer!</p>
  </div>

  <div>
    <form method="get" action="listDecks">
      <input type="submit" value="Deck List"/>
    </form>

  </div>

</body>
</html>
