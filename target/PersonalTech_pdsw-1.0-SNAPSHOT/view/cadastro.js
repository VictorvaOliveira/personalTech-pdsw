var xhr = new XMLHttpRequest();

function stateChanged() {
    if (xhr.readyState === 4 && xhr.status == 200) {
        var xml = xhr.responseXML;
        // Load XSL
        XObject = new XMLHttpRequest();
        XObject.open("GET", "xmlStylesheet.xsl", false);
        XObject.send(null);

        var xslStylesheet = XObject.responseXML;
        var xsltProcessor = new XSLTProcessor();
        xsltProcessor.importStylesheet(xslStylesheet);
        var fragment = xsltProcessor.transformToFragment(xml, document);
        document.getElementById("estado").innerHTML = "";
        document.getElementById("estado").appendChild(fragment);
    }
}

function enviarDados() {
    xhr.onreadystatechange = stateChanged;
    xhr.open("GET", "cidades.xml", true);
    xhr.send(null);
}

onload = enviarDados;