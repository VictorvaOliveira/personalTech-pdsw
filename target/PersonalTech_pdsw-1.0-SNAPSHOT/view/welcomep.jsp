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
            <a href="ReturnAlunos" class="btn btn-primary"><span class="glyphicon glyphicon-th-list"></span> Listar Alunos</a>
            </h2><a href="SettingsPersonal" class="btn btn-primary"><span class="glyphicon glyphicon-cog"></span> Configurações</a>
        </div> 
        <div class="well well-lg">
            <c:if test="${requestScope.settings == true}">
                <p> 
                    <a href="#" style="text-decoration: none;">
                        <button type="button" class="btn btn-warning">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </button>
                    </a> Atualizar informações do usuário ${sessionScope.user}
                </p>
                <p>
                    <a href="#"  style="text-decoration: none;">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                        </button>
                    </a> Listar alunos sem Personal Trainer
                </p>
                <p>
                    <a href="RemoverPersonal"  style="text-decoration: none;">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
                        </button>
                    </a> Excluir usuário ${sessionScope.user}
                </p>
                <p>
                    <a href="#"  style="text-decoration: none;">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
                        </button>
                    </a> Excluir um Personal Trainer
                </p>
            </c:if>

            <c:if test="${requestScope.alunos != null}">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.alunos}" var="a">

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