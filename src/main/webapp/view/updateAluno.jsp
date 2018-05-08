<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="top.jspf" %>
<script type="text/javascript" src="updateAluno.js"></script>
<title>PT|Atualizar Aluno</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <script src="loginButton.js"></script>
    <div class="container">
        <form class="form-horizontal" method="post" action="UpdateController">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Dados pessoais</h3></div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="nome">Nome:</label>
                <div class="col-sm-10">
                    <input required type="text" class="form-control" id="nome" placeholder="Insira nome" name="nome" value="${requestScope.aluno.getNome()}"/>
                    <span id="msgNome"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="sobrenome">Sobrenome:</label>
                <div class="col-sm-10">
                    <input required type="text" class="form-control" id="sobrenome" placeholder="Insira sobrenome" name="sobrenome" value="${requestScope.aluno.getSobrenome()}"/>
                    <span id="msgSobrenome"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="sexo">Sexo:</label>
                <div class="col-sm-10">
                    <c:if test="${requestScope.aluno.getSexo() == 'M'}">
                        <select class="form-control" id="sexo" name="sexo" required>
                            <option value="">-- Escolha um sexo --</option>
                            <option selected value="M">Masculino</option>
                            <option value="F">Feminino</option>
                        </select>
                    </c:if>
                    <c:if test="${requestScope.aluno.getSexo() == 'F'}">
                        <select class="form-control" id="sexo" name="sexo" required>
                            <option value="">-- Escolha um sexo --</option>
                            <option value="M">Masculino</option>
                            <option selected value="F">Feminino</option>
                        </select>
                    </c:if>
                    <c:if test="${requestScope.aluno.getSexo() == ''}">
                        <select class="form-control" id="sexo" name="sexo" required>
                            <option value="">-- Escolha um sexo --</option>
                            <option value="M">Masculino</option>
                            <option selected value="F">Feminino</option>
                        </select>
                    </c:if>
                    <span id="msgSexo"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">CPF:</label>
                <div class="col-sm-10">
                    <input type="txet" class="form-control" id="cpf" placeholder="Insira CPF" name="cpf" required value="${requestScope.aluno.getCpf()}"/>
                    <span id="msgCpf"/>
                </div>
            </div>

            <div class="form-group" id="AorP">
                <label for="tipoUsuarioCad" class="control-label col-sm-2">Tipo de usuário: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="tipoUsuarioCad" name="tipoUsuario" required>
                        <option value="">-- Escolha o tipo de usuário--</option>
                        <option value="P">Personal Trainer</option>
                        <option selected value="A">Aluno</option>
                    </select>
                    <span id="msgTipoUsuario"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="dataNascimento">Data de nascimento: </label>
                <div class="col-sm-10">
                    <input type="date" required class="form-control" id="dataNascimento" name="dataNascimento" value="${requestScope.alunoDataNascimento}"/>
                    <span id="msgDataNascimento"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">E-mail: </label>
                <div class="col-sm-10">
                    <input type="email" required class="form-control" id="email" placeholder="Escreva seu e-mail" name="email" value="${requestScope.aluno.getEmail()}"/>
                </div>
            </div>


            <input type="hidden" class="form-control" id="loginPersonal" placeholder="Ex.: ${sessionScope.user}" name="loginPersonal" value="${sessionScope.user}"/>


            <div class="form-group">
                <label class="control-label col-sm-2" for="login">Login: </label>
                <div class="col-sm-10">
                    <input type="text" required class="form-control" id="login" placeholder="Escreva um login único" name="login" value="${requestScope.aluno.getLogin()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha">Senha: </label>
                <div class="col-sm-10">
                    <input type="password" required class="form-control" id="senha" placeholder="Digite uma senha" name="senha" value="${requestScope.aluno.getSenha()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="confirmarSenha">Confirmar senha: </label>
                <div class="col-sm-10">
                    <input required type="password" class="form-control" id="confirmarSenha" placeholder="Confirme a senha" name="confirmarSenha" value="${requestScope.aluno.getSenha()}"/>
                    <span id="msgConfirmarSenha"/>
                </div>
                <span id='erroSenha'/>
            </div>



            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Endereço</h3></div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="logradouro">Logradouro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="logradouro" id="logradouro" placeholder="Insira logradouro" value="${requestScope.aluno.endereco.getLogradouro()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="numero">Número: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="numero" name='numero' placeholder="Ex.: 000" value="${requestScope.aluno.endereco.getNumero()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="complemento">Complemento: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Ex. apto 04 ou Próximo a esquina" value="${requestScope.aluno.endereco.getComplemento()}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="bairro">Bairro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="bairro" name="bairro" placeholder="Insira o nome bairro" value="${requestScope.aluno.endereco.getBairro()}"/>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="cep">CEP: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="cep" name="cep" placeholder="Insira o sei CEP" value="${requestScope.aluno.endereco.getCep()}"/>
                </div>
            </div>
                
            <div id="uf" class="form-group">
                <label class="control-label col-sm-2">Estados: </label> 
                <div class="col-sm-10">
                    <select class="form-control" name="estado" required></select>
                </div>
            </div>

            <div id="uf" class="form-group">
                <label class="control-label col-sm-2">Cidades: </label> 
                <div class="col-sm-10">
                    <select class="form-control" name="cidade" required></select>
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
