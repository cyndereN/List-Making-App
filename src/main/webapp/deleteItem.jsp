<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Making App</title>
</head>
<body>
<div class="main">
  <h3>Successfully deleted!</h3>
  <% String name = (String)request.getAttribute("id"); %>
  <a href="editList.html?id=<%=name%>">Back</a>
</div>
</body>
</html>