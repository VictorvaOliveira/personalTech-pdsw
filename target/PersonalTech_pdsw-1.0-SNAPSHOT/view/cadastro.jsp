<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jspf" %>
<script type="text/javascript" src="cadastro.js"></script>
<title>PT|Cadastre-se</title>
</head>
<body>
    <%@ include file="navbar.jspf" %>
    <div class="container">
        <form class="form-horizontal" method="post" action="../CadastroUser">
            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Dados pessoais</h3></div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="nome">Nome:</label>
                <div class="col-sm-10">
                    <input required type="text" class="form-control" id="nome" placeholder="Insira nome" name="nome"/>
                    <span id="msgNome"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="sobrenome">Sobrenome:</label>
                <div class="col-sm-10">
                    <input required type="text" class="form-control" id="sobrenome" placeholder="Insira sobrenome" name="sobrenome"/>
                    <span id="msgSobrenome"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="sexo">Sexo:</label>
                <div class="col-sm-10">
                    <select class="form-control" id="sexo" name="sexo" required>
                        <option selected value="">-- Escolha um sexo --</option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                    <span id="msgSexo"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">CPF:</label>
                <div class="col-sm-10">
                    <input type="txet" class="form-control" id="cpf" placeholder="Insira CPF" name="cpf" required/>
                    <span id="msgCpf"/>
                </div>
            </div>

            <div class="form-group">
                <label for="tipoUsuarioCad" class="control-label col-sm-2">Tipo de usuário: </label>
                <div class="col-sm-10">
                    <select class="form-control" id="tipoUsuarioCad" name="tipoUsuario" required>
                        <option selected value="">-- Escolha o tipo de usuário--</option>
                        <option value="P">Personal Trainer</option>
                        <option value="A">Aluno</option>
                    </select>
                    <span id="msgTipoUsuario"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="dataNascimento">Data de nascimento: </label>
                <div class="col-sm-10">
                    <input type="date" required class="form-control" id="dataNascimento" name="dataNascimento" placeholder="Personal ou Aluno"/>
                    <span id="msgDataNascimento"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">E-mail: </label>
                <div class="col-sm-10">
                    <input type="email" required class="form-control" id="email" placeholder="Escreva seu e-mail" name="email"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="loginPersonal">Login do Personal: </label>
                <div class="col-sm-10">
                    <input type="text" required class="form-control" id="loginPersonal" placeholder="Escreva um login único" name="loginPersonal"/>
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2" for="login">Login: </label>
                <div class="col-sm-10">
                    <input type="text" required class="form-control" id="login" placeholder="Escreva um login único" name="login"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="senha">Senha: </label>
                <div class="col-sm-10">
                    <input type="password" required class="form-control" id="senha" placeholder="Digite uma senha" name="senha"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="confirmarSenha">Confirmar senha: </label>
                <div class="col-sm-10">
                    <input required type="password" class="form-control" id="confirmarSenha" placeholder="Confirme a senha" name="confirmarSenha"/>
                    <span id="msgConfirmarSenha"/>
                </div>
                <span id='erroSenha'/>
            </div>



            <div class="col-sm-2"></div><div class="col-sm-10"><h3>Endereço</h3></div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="logradouro">Logradouro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="logradouro" id="logradouro" placeholder="Insira logradouro"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="numero">Número: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="numero" name='numero' placeholder="Ex.: 000"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="complemento">Complemento: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Ex. apto 04 ou Próximo a esquina"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="bairro">Bairro: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="bairro" name="bairro" placeholder="Insira o nome bairro"/>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="cep">CEP: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required id="cep" name="cep" placeholder="Insira o sei CEP"/>
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
                    <select class="form-control" name="cidade"></select>
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