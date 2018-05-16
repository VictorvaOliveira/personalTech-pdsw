var xhr = new XMLHttpRequest();
var xml;

function preencher() {
    if (xhr.readyState === 4) {
        xml = xhr.responseXML;
        var form = document.forms[0];
        var xsltProcessor = new XSLTProcessor();
        var xsl = new XMLHttpRequest();
        xsl.open("get", "exercicio.xsl");
        xsl.onreadystatechange = function () {
            if (xsl.readyState === 4) {
                var xslt = xsl.responseXML;
                xsltProcessor.importStylesheet(xslt);
                var result = xsltProcessor.transformToFragment(xml, document);
                form.exercicio.appendChild(result);
            }
        };
        xsl.send();
    }
}

function registerEvents() {
//    var form = document.forms[0].nome.addEventListener("blur", validar);
//    var form = document.forms[0].sobrenome.addEventListener("blur", validar);
//    var form = document.forms[0].sexo.addEventListener("blur", validar);
//    var form = document.forms[0].cpf.addEventListener("blur", validar);
//    var form = document.forms[0].tipoUsuario.addEventListener("blur", validar);
//    var form = document.forms[0].dataNascimento.addEventListener("blur", validar);
//    var form = document.forms[0].confirmarSenha.addEventListener("blur", validar);

    xhr.open("get", "exercicio.xml");
    xhr.onreadystatechange = preencher;
    xhr.send();
//    document.getElementsByName("exercicio")[0].onchange = preencherCidades;
    
}

onload = registerEvents;

//document.querySelector("#tipoUsuarioCad").value;