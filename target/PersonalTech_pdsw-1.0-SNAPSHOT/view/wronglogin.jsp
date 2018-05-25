<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jspf" %>
<title>PT|Login</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="logoutButton.js"></script>
    <script src="cadastroButton.js"></script>
    <script src="loginButton.js"></script>
    <div class="container">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Erro!</strong> Tipo de usuário, login ou senha estão errados.
            </div>
            <form method="post" action="../LoginController">
                <div class="form-group">
                    <label for="tipoUsuarioLogin">Tipo de usuário: </label>
                    <select class="form-control" id="tipoUsuarioLogin" name="tipoUsuarioLogin">
                        <option selected>-- Escolha o tipo de usuário--</option>
                        <option value="P">Personal Trainer</option>
                        <option value="A">Aluno</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="Login">Login:</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter login" name="login" required/>
                </div>
                <div class="form-group">
                    <label for="pwd">Senha:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="senha" required/>
                </div>
                <button type="submit" class="btn btn-primary">Entrar <span class="glyphicon glyphicon-log-in"></span></button>
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <%@ include file="bottom.jspf" %>