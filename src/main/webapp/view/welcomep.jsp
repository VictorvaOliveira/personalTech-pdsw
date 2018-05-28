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
            </c:if>
            
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
                                    <form method="post" action="ActionsAluno" name="meuform">   
                                        <input type="hidden" name="loginAluno" value="${a.getLogin()}" />
                                        <button title="Visualizar" class="btn btn-info btn-xs" value="visualizar" name="visualizar"><span class="glyphicon glyphicon-list-alt"></span></button>
                                        <button title="Editar" class="btn btn-info btn-xs" value="editar" name="editar"><span class="glyphicon glyphicon-pencil"></span></button>
                                        <button title="Avaliar" class="btn btn-info btn-xs" value="avaliar" name="avaliar"><span class="glyphicon glyphicon-copy"></span></button>
                                        <button title="Estatísticas" class="btn btn-info btn-xs" value="stats" name="stats"><span class="glyphicon glyphicon-stats"></span></button>
                                        <button title="Status Médico" class="btn btn-info btn-xs" value="medstatus" name="medstatus"><span class="glyphicon glyphicon-heart-empty"></span></button>
                                        <button title="Remover" class="btn btn-danger btn-xs" value="remover" name="remover"><span class="glyphicon glyphicon-remove"></span></button>
                                    </form>
                                </td>
                            </tr>


                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <%@include file="bottom.jspf" %>