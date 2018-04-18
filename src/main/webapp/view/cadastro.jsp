<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jspf" %>
<script type="text/javascript" src="cadastro.js"></script>
<script type="text/javascript" src="cadastroValidacoes.js"></script>
<title>PT|Cadastre-se</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <div class="container">
        <form class="form-horizontal" method="post" action="../CadastroUsuario">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Dados pessoais</h3></div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="nome">Nome:</label>
                <div class="col-sm-10">
                    <input onfocusout="verificaNome()" required type="text" class="form-control" id="nome" placeholder="Insira nome" name="nome">
                </div>
                <span id="erroNome"/>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="sobrenome">Sobrenome:</label>
                <div class="col-sm-10">
                    <input onfocusout="verificaSobrenome()" required type="text" class="form-control" id="sobrenome" placeholder="Insira sobrenome" name="sobrenome">
                </div>
                <span id="erroSobrenome"/>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="sexo">Sexo:</label>
                <div class="col-sm-10">
                    <select class="form-control" id="sexo" name="sexo" required>
                        <option selected>-- Escolha um sexo --</option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">CPF:</label>
                <div class="col-sm-10">
                    <input type="txet" class="form-control" id="cpf" placeholder="Insira CPF" name="cpf" required>
                </div>
            </div>

            <div class="form-group">
                <label for="tipoUsuarioCad" class="control-label col-sm-2">Tipo de usuário: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="tipoUsuarioCad" name="tipoUsuario" required>
                        <option selected>-- Escolha o tipo de usuário--</option>
                        <option value="P">Personal Trainer</option>
                        <option value="A">Aluno</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="dataNascimento">Data de nascimento: </label>
                <div class="col-sm-10">
                    <input type="date" required class="form-control" id="dataNascimento" name="dataNascimento" placeholder="Personal ou Aluno">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">E-mail: </label>
                <div class="col-sm-10">
                    <input type="email" required class="form-control" id="email" placeholder="Escreva seu e-mail" name="email">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="login">Login: </label>
                <div class="col-sm-10">
                    <input type="text" required class="form-control" id="login" placeholder="Escreva um login único" nome="login">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha">Senha: </label>
                <div class="col-sm-10">
                    <input type="password" required class="form-control" id="senha" placeholder="Digite uma senha" name="senha">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha2">Senha: </label>
                <div class="col-sm-10">
                    <input onfocusout="verificaSenha()" required type="password" class="form-control" id="senha2" placeholder="Confirme a senha" name="senha2">
                </div>
                <span id='erroSenha'/>
            </div>



            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Endereço</h3></div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="logradouro">Logradouro: </label>
                <div class="col-sm-10">
                        <input type="text" class="form-control" required name="logradouro" id="logradouro" placeholder="Insira logradouro">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="numero">Número: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="numero" name='numero' placeholder="Ex.: 000">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="complemento">Complemento: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Ex. apto 04 ou Próximo a esquina">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="bairro">Bairro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="bairro" name="bairro" placeholder="Insira o nome bairro">
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="cep">CEP: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="cep" name="cep" placeholder="Insira o sei CEP">
                </div>
            </div>

            <div id="estado" required></div>
            
            <div class="form-group">
                <label class="control-label col-sm-2" for="cidade">Cidade: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="cidade" name="cidade" placeholder="Insira o nome da cidade">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Cadastrar</button>
                </div>
            </div>
        </form> 
    </div>
    <%@ include file="bottom.jspf" %>