<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h1> Hi there! </h1>
<h2> This is the first Java Technologies tab. The main theme are servlets. </h2>

<form method="POST" action="handleWord">
    <h2 style="color:blue;"> Task 1 </h2>
    <h3> Below, you will find an input form. Please type a word in it, and we will make sure that it becomes a list of
        its containing letters.</h3>

    Your word goes here:
    <label>
        <input type="text" name="word" size="25"/>
    </label> <br>

    <h2 style="color:blue;"> Task 2 </h2>
    <h3> Below, you will find an input form. Please provide an integer, this will represent the length of the
        permutations of the word above. We will return those as well.</h3>

    Your chosen size goes here:
    <label>
        <input type="text" name="size" size="25"/>
    </label> <br>

    <br>

    <label>
        <input type="submit" name="submit" value="Submit"/>
    </label> <br>
</form>
</body>
</html>