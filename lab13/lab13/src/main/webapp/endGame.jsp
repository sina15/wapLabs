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
<%!
int score;
int totalQuiz;
%>

<%

    score = session.getAttribute("score")==null?0:Integer.parseInt(session.getAttribute("score").toString());
    totalQuiz = request.getAttribute("totalQuiz")==null?0:Integer.parseInt(request.getAttribute("totalQuiz").toString())+1;

%>
<div id="endedgame" >
    <div style="width:500px; margin-left: auto;margin-right: auto; border:1px solid blue">
        <header>

            <h1>The Number Quiz</h1>
        </header>
        <section>
            <p>Your Current Score is <span><%=score%></span></p>
            <div>
                <p>You have Completed the Number Quiz , with a score <%= score %> out of <%=totalQuiz %></p>
            </div>


        </section>
    </div>
</div>
</body>
</html>
