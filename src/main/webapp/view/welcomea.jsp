<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <div class="container">
        <h1>Bem vindo, ${sessionScope.user} !</h1>
        <div class="btn-group btn-group-justified">
            <a href="ReturnExercicios" class="btn btn-primary"><span class="glyphicon glyphicon-th-list"></span> Listar Exercícios</a>
            <a href="SettingsAluno" class="btn btn-primary"><span class="glyphicon glyphicon-cog"></span> Configurações</a>
        </div> 

        <div class="well well-lg">
            <c:if test="${requestScope.settings == true}">
                <form method="post" action="ActionsAluno" name="meuform">   
                    <input type="hidden" name="loginAluno" value="${aluno.getLogin()}" />
                    <input type="hidden" name="idAluno" value="${aluno.getId()}" />
                    <p><button title="Editar" class="btn btn-info btn-xs" value="editar" name="editar"><span class="glyphicon glyphicon-pencil"></span></button> Atualizar os dados pessoais</p>
                    <!--<button title="Remover" class="btn btn-danger btn-xs" value="remover" name="remover"><span class=" glyphicon glyphicon-remove"></span></button>-->
                </form>
            </c:if>
            <c:if test="${requestScope.settings != true}">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Tipo</th>
                            <th>Exercício</th>
                            <th>Descrição</th>
                        </tr>
                    </thead>
                    <c:forEach items="${sessionScope.aluno.exercicios}" var="ex">
                        <tr>
                            <td>${ex.getTipo()}</td>
                            <td>${ex.getExercicio()}</td>
                            <td>${ex.getSerie()}x${ex.getRepeticao()} com ${ex.getPeso()}Kg</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                
                <div id="chart_div" style="width: 50%; height: 250px;"></div>
                <script type="text/javascript">
                    google.charts.load('current', {'packages': ['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        var data = google.visualization.arrayToDataTable([
                            ['Year'    , 'Peso', 'IMC'],
                            ['Jan/2018',    100,    35],
                            ['Mar/2018',     70,    24],
                            ['Jun/2018',     66,    24],
                            ['Out/2018',     65,  23.5]
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