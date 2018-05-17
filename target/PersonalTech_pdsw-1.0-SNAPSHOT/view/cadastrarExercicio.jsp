<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="top.jspf" %>
<script type="text/javascript" src="updateExercicio.js"></script>
<title>PT|Cadastrar Exercício</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h4>Cadastrar Exercício</h4>
        <form class="form-horizontal" method="post" action="CadastrarExercicio">

            <div id="newExercise" class="form-group">
                <label class="control-label col-sm-2">Exercícios: </label> 
                <div class="col-sm-10">
                    <select class="form-control" name="exercicio" required></select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="serie">Séries: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="serie"  value="${requestScope.ex.getSerie()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="repeticao">Repetições: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="repeticao"  value="${requestScope.ex.getRepeticao()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="peso">Peso (kg): </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="peso"  value="${requestScope.ex.getPeso()}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Cadastrar</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                    <a href="index.jsp"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
            </div>
        </form> 
    </div>
    <%@include file="bottom.jspf" %>
