<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h1>Exercícios de ${requestScope.aluno.getNome()}</h1>
        <div class="btn-group btn-group-justified">
            <a href="cadastrarExercicio.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Adicionar Exercícios</a>
        </div> 
        <div class="well well-lg">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Exercício</th>
                        <th>Descrição</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.aluno.exercicios}" var="ex">
                    <tr>
                        <td>${ex.getTipo()}</td>
                        <td>${ex.getExercicio()}</td>
                        <td>${ex.getSerie()}x${ex.getRepeticao()} com ${ex.getPeso()}Kg</td>
                        <td>
                            <form method="post" action="ActionsExercicio" name="meuform">   
                                <input type="hidden" name="loginAluno" value="${aluno.getLogin()}" />
                                <input type="hidden" name="idAluno" value="${aluno.getId()}" />
                                <input type="hidden" name="idExercicio" value="${ex.getId()}" />
                                <button title="Editar" class="btn btn-info btn-xs" value="editar" name="editar"><span class="glyphicon glyphicon-pencil"></span></button>
                                <button title="Remover" class="btn btn-danger btn-xs" value="remover" name="remover"><span class=" glyphicon glyphicon-remove"></span></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%@include file="bottom.jspf" %>