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
        <form class="form-horizontal" method="post" action="CadastroStatusMedico">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Dados Médicos</h3></div>
            <div class="form-group">
                <label for="" class="control-label col-sm-2">Diabetes: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="diabetes" name="diabetes" required>
                        <option selected value="negativo">Não Diabético</option>
                        <option value="Tipo 1">Tipo 1</option>
                        <option value="Tipo 2">Tipo 2</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="" class="control-label col-sm-2">Pressão Arterial: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="pressao" name="pressao" required>
                        <option selected value="negativo">Não apresenta problema de pressão</option>
                        <option value="hipertensao">Hipertensão</option>
                        <option value="hipotensao">Hipotensão</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="" class="control-label col-sm-2">Observação sobre Pressão Arterial: </label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="2" cols="50" maxlength="100" name="obsPresArt"></textarea> 
                </div>
            </div>

            <div class="form-group">
                <label for="" class="control-label col-sm-2">Problema Cardíaco: </label>
                <div class="col-sm-10">
                    <input type="radio" name="cardiaco" value="positivo"> Sim
                    <input type="radio" name="cardiaco" value="negativo"> Não
                </div>
            </div> 
            <div class="form-group">
                <label for="" class="control-label col-sm-2">Observação sobre Problema Cardíaco: </label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="2" cols="50" maxlength="100" name="obsProbCard"></textarea> 
                </div>
            </div>

            <div class="form-group">
                <label for="" class="control-label col-sm-2">Problema Ósseo: </label>
                <div class="col-sm-10">
                    <input type="radio" name="osseo" value="positivo"> Sim
                    <input type="radio" name="osseo" value="negativo"> Não
                </div>
            </div> 
            <div class="form-group">
                <label for="" class="control-label col-sm-2">Observação sobre Problema Ósseo: </label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="2" cols="50" maxlength="100" name="obsProbOsseo"></textarea> 
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
