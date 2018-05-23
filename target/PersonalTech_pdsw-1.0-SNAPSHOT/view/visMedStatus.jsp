<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <c:out value="${requestScope.alunos1}"/>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h1>Bem-vindo, <span id="personal">${sessionScope.user}</span>!</h1>
        <div class="btn-group btn-group-justified">
            <a href="" class="btn btn-primary"><span class="glyphicon glyphicon-heart-empty"></span> Status Médico</a>
            </h2><a href="cadStatusMedico.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Cadastrar | Editar</a>
        </div>
        <div class="well well-lg">
            <c:if test="${requestScope.medStatus == null}">
                <h3>Ainda não há status médico definido. Cadastre o status médico no botão "Cadastrar" localizado na barra superior.</h3>
            </c:if>
            <c:if test="${requestScope.medStatus != null}">
                <h3>// TODO</h3>
            </c:if>
        </div>
    </div> 
    <%@include file="bottom.jspf" %>