<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>List Making App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h3>Lists:</h3>
  <ul>
    <%
      ArrayList<String> listNames = (ArrayList<String>) request.getAttribute("lists");
      for (String name : listNames)
      {
    %>
    <li>
        <a href="viewList.html?id=<%=name%>"><%=name%></a>
        <a href="editList.html?id=<%=name%>">edit</a>
        <a href="deleteList.html?id=<%=name%>">delete</a>
    </li>
    <% } %>
  </ul>
</div>

<jsp:include page="/footer.jsp"/>
</body>
</html>
