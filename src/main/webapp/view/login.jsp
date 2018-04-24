<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jspf" %>
<title>PT|Login</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <div class="container">
        <h2>PersonalTech</h2>
        <form action="../LoginController" method="post">
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
                <input type="text" class="form-control" id="email" placeholder="Enter login" name="login" value="bino">
            </div>
            <div class="form-group">
                <label for="pwd">Senha:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="senha" value="123">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
    <%@ include file="bottom.jspf" %>
