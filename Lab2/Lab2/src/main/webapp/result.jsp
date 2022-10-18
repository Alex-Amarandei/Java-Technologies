<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    body {
        background: #acb6e5; /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #86fde8, #acb6e5); /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #86fde8, #acb6e5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

        font-family: "Avenir Next", sans-serif;
    }

    h1 {
        margin-top: 100px;
        text-align: center;
    }

    h2 {
        margin-top: 50px;
        text-align: center;
    }

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #acb6e5;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #7980a3;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
        width: 50%;
        margin: auto;
    }
</style>

<head>
    <title>Java Technologies - Lab 2</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Go Back</a>
<h2>Word: ${word} | Size: ${size}</h2>

<ol>
    <c:forEach items="${task1Result}" var="character">
        <li>${character}</li>
    </c:forEach>
</ol>

<p>
    <c:forEach items="${task2Result}" var="word">
        ${word}
    </c:forEach>
</p>

<br/>
<hr/>

<h2>See? Just as promised.</h2>
</body>
</html>
