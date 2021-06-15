<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Making App</title>
</head>
<body>
<div class="main">
  <h3>Successfully edited!</h3>
  <p>If you changed a file name to what already exists, the list remains the same and this page will take you to the existing page.</p>
  <% String name = (String)request.getAttribute("id"); %>
  <a href="editList.html?id=<%=name%>">Back</a>
</div>
</body>
</html>