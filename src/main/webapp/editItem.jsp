<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Making App</title>
</head>
<body>
<div class="main">
  <h1>Edit</h1>
  <%
    String name = (String)request.getAttribute("id");
    String val = (String)request.getAttribute("val");
    %>
  <form method="POST" action="editConfirm.html?id=<%=name%>&val=<%=val%>">
    <input type = "text" name = "newItem" />
    <input type = "submit" value = "Confirm"/>
  </form>
  <p>Note: </p>
  <p>For list name, directly input new text, e.g. HelloWorld</p>
  <p>For pure text, input "T: " at first, e.g. T: HelloWorld</p>
  <p>For URL, input "U: " at first and includes protocol if external, e.g. U: https://www.google.com</p>
  <p>For image, input "I: " at first and make sure images are under folder "webapp/images", e.g. I: 1.jpg</p>
  <p>For another list, input "L: " at first and then input list name, e.g. L: Name1</p>
  <p>For combination, input " ; " between (there are white spaces to both sides of ';'!), e.g. L: Name1 ; T: HelloWorld</p>
</div>
</body>
</html>