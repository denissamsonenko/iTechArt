<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <title>ListFigures</title>
</head>
<body>
<div class="wrapper">
    <div class="main">
        <div class="main_header">
            <h1>List figures</h1>
        </div>
        <div class="link_list">
            <a href="/list">Go to unsorted</a>
        </div>
        <div class="main_list">
            <c:forEach var="list" items="${list}">
                <div>
                        ${list}
                </div>
            </c:forEach>
        </div>

        <div class="main_form">
            <form action="list" method="post">
                <div class="main_list-label">
                    <label >Sorted items</label>
                </div>
                <div>
                <button class="main_form-button" type="submit">OrderList</button>
                </div>
            </form>
        </div>

        <div class="main_list">
            <c:forEach var="sortList" items="${sortList}">
                <div>
                        ${sortList}
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

