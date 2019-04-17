<%--
  Created by IntelliJ IDEA.
  User: christophehabineza
  Date: 2019-04-17
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number Quiz</title>
</head>


<body>


<div style="width: 500px; margin-left: auto;margin-right: auto; border:1px solid blue" id="ongoinggame">
    <header>

        <h1>The Number Quiz</h1>
    </header>
    <section>
        <p>Your Current Score is <span>${score}</span></p>
        <p>Guess the next number in the sequence.</p>
        <div>
            <p>3,1,4,1,5</p>
        </div>

        <form action="quiz" method="post" style="margin-bottom: 30px;">
            <label>Your Answer: &nbsp;<input type="number" name="result"></label><br/><b/>
            <input type="submit" value="Submit">
        </form>
    </section>
</div>




</body>

</html>
