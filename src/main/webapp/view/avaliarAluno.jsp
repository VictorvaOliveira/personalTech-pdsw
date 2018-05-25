
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="top.jspf" %>
<script type="text/javascript" src="updateAluno.js"></script>
<title>PT|Dados médicos</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <form class="form-horizontal" method="post" action="CadastroAvaliacao">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Avaliação periódica</h3></div>
            <div class="form-group">
                <label for="peso" class="control-label col-sm-2">Peso (kg): </label>
                <div class="col-sm-10">
                    <input type="number" step="0.01" class="form-control" placeholder="80.55" id="peso" name="peso" required/>
                </div>
            </div>

            <div class="form-group">
                <label for="altura" class="control-label col-sm-2">Altura (m): </label>
                <div class="col-sm-10">
                    <input type="number" step="0.01" class="form-control" placeholder="1.75" id="altura" name="altura" required/>
                </div>
            </div>

            <div class="form-group">
                <label for="pressao" class="control-label col-sm-2">Pressão Aterial (mmHg):</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="120/80" id="pressao" name="pressao" required/>
                </div>
            </div>

            <div class="form-group">
                <label for="obspressao" class="control-label col-sm-2">OBS. sobre Pressão Aterial: </label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="2" cols="50" maxlength="100"id="obspressao" name="obspressao"></textarea> 
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="dataatual">Data atual: </label>
                <div class="col-sm-10">
                    <input type="date"class="form-control" id="dataatual" name="dataatual" value="${requestScope.dataAtual}" required readonly/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Cadastrar</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                    <a href="visMedStatus.jsp"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
            </div>
        </form> 
    </div>
    <%@include file="bottom.jspf" %>
