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
       <%
        MyList list = (MyList)request.getAttribute("list");
        String name = list.getName();
        int val = 0;
       %>
  <h3><%= name %> <a href="editItem.html?id=<%=name%>&val=<%=val%>">edit</a></h3>
  <ol>
    <%

      for (String item : list.getItems())
      {    val += 1;
    %>
    <li>  <%=item%> <a href="editItem.html?id=<%=name%>&val=<%=val%>">edit</a>
                    <a href="deleteItem.html?id=<%=name%>&val=<%=val%>">delete</a>
    </li>
    <% } %>
    <a href="editItem.html?id=<%=name%>&val=<%=val+1%>">add</a>
  </ol>
</div>
<a href = "lists.html">Lists</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
