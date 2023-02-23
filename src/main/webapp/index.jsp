<jsp:useBean id="emailBean" scope="request" type="com.example.projectemail.bean.EmailBean"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Project</title>
</head>
<body>
<h1><%= "Hello World!!" %>
</h1>
<br/>
<commandButton>value="Enviar" action="#{emailBean.enviarEmail}"</commandButton>
<button>Click Aqui</button>
</body>
</html>