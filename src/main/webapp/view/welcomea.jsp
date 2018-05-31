<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="top.jspf" %>
<title>AL|Bem-vindo</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <div class="container">
        <h1>Bem vindo, ${sessionScope.user} !</h1>
        <div class="btn-group btn-group-justified">
            <a href="ReturnExercicios" class="btn btn-primary"><span class="glyphicon glyphicon-th-list"></span> Informações</a>
            <a href="SettingsAluno" class="btn btn-primary"><span class="glyphicon glyphicon-cog"></span> Configurações</a>
        </div> 

        <div class="well well-lg">
            <!-- 
                MENU PARA CONFIGURAÇÕES
            -->
            <c:if test="${requestScope.settings == true}">
                <form method="post" action="ActionsAluno" name="meuform">   
                    <input type="hidden" name="loginAluno" value="${aluno.getLogin()}" />
                    <input type="hidden" name="idAluno" value="${aluno.getId()}" />
                    <p><button title="Editar" class="btn btn-info btn-xs" value="editar" name="editar"><span class="glyphicon glyphicon-pencil"></span></button> Atualizar os dados pessoais</p>
                </form>
            </c:if>
            <!-- 
                LISTA DAS INFORMAÇÕES RELACIONADAS AO ALUNO
            -->
            <c:if test="${requestScope.settings != true}">
                <div>
                    <h4>Lista de exercícios</h4>
                    <c:if test="${sessionScope.aluno.exercicios == null}">
                        <p>Não há exercícios cadastrados para esse aluno. Entrar em contato com seu personal trainer!</p>
                    </c:if>
                    <c:if test="${sessionScope.aluno.exercicios != null}">    
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Tipo</th>
                                    <th>Exercício</th>
                                    <th>Descrição</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.aluno.exercicios}" var="ex">
                                    <tr>
                                        <td>${ex.getTipo()}</td>
                                        <td>${ex.getExercicio()}</td>
                                        <td>${ex.getSerie()} x ${ex.getRepeticao()} com ${ex.getPeso()}Kg</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div>
                    <h4>Avaliações</h4>
                    <c:if test="${sessionScope.aluno.avaliacoes == null}">
                        <p>Não foi realizada nenhuma avaliação. Entrar em contato com seu personal trainer !</p>
                    </c:if>
                    <c:if test="${sessionScope.aluno.avaliacoes != null}">
                        <table class="table table-bordered">
                            <thead>
                            <th>Data avaliação</th>
                            <th>Peso</th>
                            <th>Pressão arterial</th>
                            <th>Altura</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.aluno.avaliacoes}" var="ava">
                                    <tr>
                                        <td><fmt:formatDate value="${ava.getDataAvaliacao()}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${ava.getPeso()} Kg</td>
                                        <td>${ava.getPressaoArtAtual()}</td>
                                        <td>${ava.getAltura()}</td> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div>
                            <h4>Gráfico de acompanhamento</h4>
                            <div id="chart_div" style="width: 75%; height: 250px;"></div>
                        </div>
                    </c:if>
                </div>
                <script type="text/javascript">
                    google.charts.load('current', {'packages': ['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        var data = google.visualization.arrayToDataTable([
                            ['Year', 'Peso'],
                    <c:forEach items="${sessionScope.aluno.avaliacoes}" var="ava">
                            ['<fmt:formatDate value="${ava.getDataAvaliacao()}" type="both" pattern="MM/yyyy" dateStyle="full"/>', ${ava.getPeso()}],
                    </c:forEach>
                        ]);

                        var options = {
                            title: 'Peso/IMC',
                            hAxis: {title: '', titleTextStyle: {color: '#333'}},
                            vAxis: {minValue: 0}
                        };

                        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
                        chart.draw(data, options);
                    }
                </script>
            </c:if>
        </div>
    </div>
    <%@include file="bottom.jspf" %>