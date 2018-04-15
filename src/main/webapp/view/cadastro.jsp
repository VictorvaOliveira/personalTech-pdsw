<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jspf" %>
<script src="cadastro.js"></script>
<title>PT|Cadastre-se</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <div class="container">
        <form class="form-horizontal" action="/action_page.php">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Dados pessoais</h3></div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="nome">Nome:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nome" placeholder="Insira nome">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="sobrenome">Sobrenome:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="sobrenome" placeholder="Insira sobrenome">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="sexo">Sexo:</label>
                <div class="col-sm-10">
                    <select class="form-control" id="sexo">
                        <option selected>-- Escolha um sexo --</option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">CPF:</label>
                <div class="col-sm-10">
                    <input type="txet" class="form-control" id="cpf" placeholder="Insira CPF">
                </div>
            </div>

            <div class="form-group">
                <label for="tipoUsuarioCad" class="control-label col-sm-2">Tipo de usuário: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="tipoUsuarioCad">
                        <option selected>-- Escolha o tipo de usuário--</option>
                        <option value="P">Personal Trainer</option>
                        <option value="A">Aluno</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="dataNascimento">Data de nascimento: </label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="dataNascimento" placeholder="Personal ou Aluno">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">E-mail: </label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" placeholder="Escreva seu e-mail">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="login">Login: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="login" placeholder="Escreva um login único">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha">Senha: </label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="senha" placeholder="Digite uma senha">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha2">Senha: </label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="senha2" placeholder="Confirme a senha">
                </div>
            </div>



            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Endereço</h3></div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="logradouro">Logradouro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="logradouro" placeholder="Insira logradouro">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="numero">Número: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="numero" placeholder="Ex.: 000">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="complemento">Complemento: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="complemento" placeholder="Ex. apto 04 ou Próximo a esquina">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="bairro">Bairro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="bairro" placeholder="Insira o nome bairro">
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="cep">CEP: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cep" placeholder="Insira o sei CEP">
                </div>
            </div>

            <div id="estado"></div>
            
            <div class="form-group">
                <label class="control-label col-sm-2" for="cidade">Cidade: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cidade" placeholder="Insira o nome da cidade">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Cadastrar</button>
                </div>
            </div>
        </form> 
    </div>
    <%@ include file="bottom.jspf" %>