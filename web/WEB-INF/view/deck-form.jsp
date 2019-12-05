<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Wolf
  Date: 12/4/2019
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/resources/js/scripts.js"></script>
    <title>Edit Deck</title>
</head>
<body>
    <div id="container">
        <div id="content">
            <form:form action="${contextPath}/deck/save"  modelAttribute="deck" method="POST">
                <form:hidden path="id" value="${deck.id}"/>

                <table>
                    <tr>
                        <td><label>Name</label></td>
                        <td><form:input path="name"/>
                            <form:errors path="name" cssClass="error"/> </td>
                    </tr>
                    <tr>
                        <td><label>Format</label></td>
                        <td><form:input path="format"/>
                            <form:errors path="format" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td>

                        </td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </table>

            </form:form>
        </div>
    </div>
    
</body>
</html>
