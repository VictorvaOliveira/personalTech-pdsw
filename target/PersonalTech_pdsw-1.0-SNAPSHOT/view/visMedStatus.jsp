<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="top.jspf" %>
<title>PT|Bem-vindo</title>
</head>
<body>
    <c:set scope="page" var="medStatus" value="${sessionScope.aluno.medStatus}"/>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <h1>Bem-vindo, <span id="personal">${sessionScope.user}</span>!</h1>
        <div class="btn-group btn-group-justified">
            </h2><a href="cadStatusMedico.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Cadastrar | Editar</a>
        </div>
        <div class="well well-lg">

            <c:if test="${medStatus == null}">
                <h3>Ainda não há status médico definido. Cadastre o status médico no botão "Cadastrar" localizado na barra superior.</h3>
            </c:if>
            <c:if test="${medStatus != null}">
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Diabetes</th>
                            <td>${medStatus.getDiabetes()}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Pressão Arterial</th>
                                <c:choose>
                                    <c:when test="${medStatus.getProbPressaoAterial() == 'hipotensao'}">
                                    <td>Hipotensão</td>
                                </c:when>
                                    <c:when test="${medStatus.getProbPressaoAterial() == 'hipertensao'}">
                                    <td>Hipertensão</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Não apresenta problema de pressão</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${medStatus.getObsProbPressaoAterial()}</td>
                        </tr>
                        <tr>
                            <th>Problema Cardíaco</th>
                            <c:choose>
                                    <c:when test="${medStatus.getProbCardiaco() == true}">
                                    <td>Sim</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Não</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${medStatus.getObsProbCardiaco()}</td>
                        </tr>
                        <tr>
                            <th>Problema Ósseo</th>
                            <c:choose>
                                    <c:when test="${medStatus.getProbOsseo() == true}">
                                    <td>Sim</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Não</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${medStatus.getObsprobOsseo()}</td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div> 
    <%@include file="bottom.jspf" %>