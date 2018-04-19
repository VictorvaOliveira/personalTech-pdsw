var xhr = new XMLHttpRequest();
var xml;

function preencher() {
    if (xhr.readyState === 4) {
        xml = xhr.responseXML;
        var form = document.forms[0];
        var xsltProcessor = new XSLTProcessor();
        var xsl = new XMLHttpRequest();
        xsl.open("get", "estados.xsl");
        xsl.onreadystatechange = function () {
            if (xsl.readyState === 4) {
                var xslt = xsl.responseXML;
                xsltProcessor.importStylesheet(xslt);
                var result = xsltProcessor.transformToFragment(xml, document);
                form.estado.appendChild(result);
                preencherCidades();
            }
        };
        xsl.send();
    }
}

function preencherCidades() {
    var form = document.forms[0];
    var estado = form.estado.value;
    var xsltProcessor = new XSLTProcessor();
    var xsl = new XMLHttpRequest();
    xsl.open("get", "cidades.xsl");
    xsl.onreadystatechange = function () {
        if (xsl.readyState === 4) {
            var xslt = xsl.responseXML;
            xsltProcessor.importStylesheet(xslt);
            xsltProcessor.setParameter(null, "uf", estado);
            var result = xsltProcessor.transformToFragment(xml, document);
            form.cidade.innerHTML = "";
            form.cidade.appendChild(result);
        }
    };
    xsl.send();
}


function mostrarErros() {
    if (xhr.readyState === 4) {
        var obj = JSON.parse(xhr.responseText);
        var msgNome = document.getElementById("msgNome");
        msgNome.textContent = obj.msgNome;
        var msgSobrenome = document.getElementById("msgSobrenome");
        msgSobrenome.textContent = obj.msgSobrenome;
        var msgSexo = document.getElementById("msgSexo");
        msgSexo.textContent = obj.msgSexo;
        var msgCpf = document.getElementById("msgCpf");
        msgCpf.textContent = obj.msgCpf;
        var msgTipoUsuario = document.getElementById("msgTipoUsuario");
        msgTipoUsuario.textContent = obj.msgTipoUsuario;
        var msgDataNascimento = document.getElementById("msgDataNascimento");
        msgDataNascimento.textContent = obj.msgDataNascimento;
        var msgConfirmarSenha = document.getElementById("msgConfirmarSenha");
        msgConfirmarSenha.textContent = obj.msgConfirmarSenha;
    }

}

function validar() {
    xhr.open("post", "../ValidacaoController");
    xhr.onreadystatechange = mostrarErros;
    var formData = new FormData(document.forms[0]);
    xhr.send(formData);
}

function registerEvents() {
    var form = document.forms[0].nome.addEventListener("blur", validar);
    var form = document.forms[0].sobrenome.addEventListener("blur", validar);
    var form = document.forms[0].sexo.addEventListener("blur", validar);
    var form = document.forms[0].cpf.addEventListener("blur", validar);
    var form = document.forms[0].tipoUsuario.addEventListener("blur", validar);
    var form = document.forms[0].dataNascimento.addEventListener("blur", validar);
    var form = document.forms[0].confirmarSenha.addEventListener("blur", validar);

    xhr.open("get", "cidades.xml");
    xhr.onreadystatechange = preencher;
    xhr.send();
    document.getElementsByName("estado")[0].onchange = preencherCidades;
}

onload = registerEvents;