<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h1>Bem-vindo, <span id="personal">${sessionScope.user}</span>!</h1>
        <div class="btn-group btn-group-justified">
            <a href="#" class="btn btn-primary">Ver Status</a>
        </div> 
        <div class="well well-lg">       
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Peso</th>
                        <th>IMC</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                        <td>john@example.com</td>
                        <td>
                            <a href="#" title="Editar"><span class="glyphicon glyphicon-pencil" id="editar"/></a>
                            <a href="#" title="Avaliar"><span class="glyphicon glyphicon-copy" id="avaliar"/></a>
                            <a href="#" title="Deletar"><span class="glyphicon glyphicon-remove" id="remover"/></a>
                            <a href="#" title="Ver Gráfio"><span class="glyphicon glyphicon-stats" id="status"/></a>
                        </td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                        <td>john@example.com</td>
                        <td>
                            <a href="#" title="Editar"><span class="glyphicon glyphicon-pencil" id="editar"/></a>
                            <a href="#" title="Avaliar"><span class="glyphicon glyphicon-copy" id="avaliar"/></a>
                            <a href="#" title="Deletar"><span class="glyphicon glyphicon-remove" id="remover"/></a>
                            <a href="#" title="Ver Gráfico"><span class="glyphicon glyphicon-stats" id="status"/></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <%@include file="bottom.jspf" %>