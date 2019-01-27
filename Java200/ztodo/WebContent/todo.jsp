<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
    <jsp:useBean id="items" type="java.util.LinkedList<String>" scope="request" />
    <div class="main">  
        <% for(String item: items) { %>
            <div class="item">     
                <p><%=item%></p>
            </div>
        <% } %> 
    
    </div>
</body>
</html>