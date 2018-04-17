function verificaNome() {
    var nome = document.getElementById("nome").value;
    var mensagem = document.getElementById("erroNome");

    if (nome.length < 3 || nome.length > 50) {
        mensagem.innerHTML = "O nome deve três entre 3 e 50 caracteres!";
    } else {
        mensagem.innerHTML = "";
    }
}

function verificaSobrenome() {
    var nome = document.getElementById("sobrenome").value;
    var mensagem = document.getElementById("erroSobrenome");

    if (nome.length < 3 || nome.length > 50) {
        mensagem.innerHTML = "O sobrenome deve três entre 3 e 50 caracteres!";
    } else {
        mensagem.innerHTML = "";
    }
}

function verificaSenha() {
    var senha = document.getElementById("senha");
    var senha2 = document.getElementById("senha2");
    var mensagem = document.getElementById("erroSenha");

    if (senha.value != senha2.value) {
        mensagem.innerHTML = "As senhas devem ser iguais";
    } else {
        mensagem.innerHTML = "";
    }
}
