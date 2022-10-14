<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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

<h1> Hi there! </h1>
<h2> This is the second Java Technologies tab. </h2>

<div>
    <form method="POST" action="handleWord">
        <label for="word">Word</label>
        <input type="text" id="word" name="word" placeholder="Your word goes here...">

        <label for="size">Size</label>
        <input type="text" id="size" name="size" placeholder="The size goes here...">

        <label for="task">Task</label>
        <select id="task" name="task">
            <option value="task1"> Task 1: Convert to list of characters.</option>
            <option value="task2"> Task 2: Generate valid anagrams from character subsets.</option>
        </select>

        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>