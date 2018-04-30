<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h1>Bem-vindo, <span id="personal">${sessionScope.user}</span>!</h1>
        <div class="btn-group btn-group-justified">
            <a href="../ReturnAlunos" class="btn btn-primary">Listar Alunos</a>
            <a href="#" class="btn btn-primary">Avaliar Aluno</a>
        </div> 
        <div class="well well-lg">       
        <c:if test="${sessionScope.alunos != null}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Login</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
            <c:forEach items="${sessionScope.alunos}" var="a">

                    <tr>
                        <td>${a.getNome()}</td>
                        <td>${a.getLogin()}</td>
                        <td>
                            <a href="#" title="Visualizar"><span class="glyphicon glyphicon-list-alt" id="visualizar"/></a>
                            <a href="#" title="Editar"><span class="glyphicon glyphicon-pencil" id="editar"/></a>
                            <a href="#" title="Avaliar"><span class="glyphicon glyphicon-copy" id="avaliar"/></a>
                            <a href="#" title="Deletar"><span class="glyphicon glyphicon-remove" id="remover"/></a>
                            <a href="#" title="Ver Estatísticas"><span class="glyphicon glyphicon-stats" id="status"/></a>
                        </td>
                    </tr>
                

            </c:forEach>
                </tbody>
            </table>
        </c:if>
        </div>
    </div>
    <%@include file="bottom.jspf" %>