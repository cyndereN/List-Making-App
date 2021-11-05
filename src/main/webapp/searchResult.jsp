<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<String> names = (List<String>) request.getAttribute("result");
    if (names.size() !=0)
    {
    %>
    <ul>
      <%
        for (String name : names)
        {
      %>
      <li><a href="viewList.html?id=<%=name%>"><%=name%></a></li>
     <% }
    } else
    {%>
      <p>Nothing found.</p>
  <%}%>
  </ul>
</div>
<a href = "lists.html">Lists</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>