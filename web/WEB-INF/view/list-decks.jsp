<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Wolf
  Date: 9/12/2019
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>DeckOrganizer - DeckList</title>
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/resources/js/scripts.js"></script>
    <title>Decks</title>

</head>
<body>
    <%@include file="../../nav.html"%>
    <button class="add-button" onclick="window.location.href='${contextPath}/deck/showAddDeckForm'; return false;">Add Deck</button>

    <form:form action="search" method="GET">
        Search Decks <input type="search" name="searchTerm"/>
        <input type="submit" value="Search" class="ui-button"/>
    </form:form>

    <table>
        <tr>
            <th>Deck Name</th>
            <th>User</th>
            <th>Action</th>
        </tr>
        <c:forEach var="tempDeck" items="${decks}">
            <c:url var="updateLink" value="/deck/showUpdateDeckForm">
                <c:param name="deckId" value="${tempDeck.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/deck/delete">
                <c:param name="deckId" value="${tempDeck.id}"/>
            </c:url>

            <tr>
                <td>${tempDeck.name}</td>
                <td>${tempDeck.user.username}</td>
                <td>
                    <a href="${updateLink}">Edit</a>
                    <a href="${deleteLink}" onclick="if (!confirm('Ar you sure?')) return false">Delete</a>
                </td>
            </tr>

        </c:forEach>
    </table>


<%--    <div class="container text-center" id="divDeckList">--%>
<%--        decks:--%>
<%--        ${deckList}--%>
<%--    </div>--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6 offset-md-3">--%>
<%--                <a href="../../NewDeck.html" class="btn-secondary border rounded p-2" name="btnAddDeck">New Deck</a>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
    
</body>
</html>
