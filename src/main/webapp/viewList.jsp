<%@ page import="uk.ac.ucl.model.MyList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>List Making App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h3><%
        MyList list = (MyList)request.getAttribute("list");
       %><%= list.getName() %></h3>
  <ol>
    <%

      for (String item : list.getItems())
      {
    %>
    <li>  <%=item%>
    </li>
    <% } %>
  </ol>
</div>
<a href = "lists.html">Back</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
