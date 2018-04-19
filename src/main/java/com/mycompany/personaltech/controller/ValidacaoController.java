package com.mycompany.personaltech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "ValidacaoController", urlPatterns = {"/ValidacaoController"})
@MultipartConfig
public class ValidacaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();

        String nome = request.getParameter("nome");
        if (nome.isEmpty()) {
            obj.put("msgNome", "");
        } else if (nome.length() <= 2) {
            obj.put("msgNome", "O nome tem que ter mais de 2 caracteres");
        } else if (nome.matches(".*\\d+.*")) {
            obj.put("msgNome", "O nome não pode conter números. Apenas letras");
        }

        String sobrenome = request.getParameter("sobrenome");
        if (sobrenome.isEmpty()) {
            obj.put("msgSobrenome", "");
        } else if (sobrenome.length() <= 2) {
            obj.put("msgSobrenome", "O nome tem que ter mais de 2 caracteres");
        } else if (sobrenome.matches(".*\\d+.*")) {
            obj.put("msgSobrenome", "O nome não pode conter números. Apenas letras");
        }

        String sexo = request.getParameter("sexo");
        if (!sexo.equals("M") && !sexo.equals("F")) {
            obj.put("msgSexo", "Você deve escolher um gênero");
        } else {
            obj.put("msgSexo", "");
        }

        String cpf = request.getParameter("cpf");
        if (cpf.isEmpty()) {
            obj.put("msgCpf", "");
        } else if ((cpf.length() < 11 || cpf.length() > 14)) {
            obj.put("msgCpf", "Este cpf é inválido");
        }

        String tipoUsuario = request.getParameter("tipoUsuario");
        if (!tipoUsuario.equals("P") && !tipoUsuario.equals("A")) {
            obj.put("msgTipoUsuario", "Você deve escolher um tipo de usuário");
        } else {
            obj.put("msgTipoUsuario", "");
        }

        String dataNascimento = request.getParameter("dataNascimento");
        if (dataNascimento.isEmpty()) {
            obj.put("dataNascimento", "");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date data = sdf.parse(dataNascimento);
                Date atual = new Date();
                Calendar cal = new GregorianCalendar();
                cal.setTime(atual);
                cal.add(Calendar.YEAR, -10);
                Date maior18 = cal.getTime();

                cal.setTime(atual);
                cal.add(Calendar.YEAR, -100);
                Date menor70 = cal.getTime();

                if (maior18.before(data)) {
                    obj.put("msgDataNascimento", "Vc deve ter mais que 10 anos");
                } else if (menor70.after(data)) {
                    obj.put("msgDataNascimento", "Vc deve ter menos que 100 anos");
                } else {
                    obj.put("msgDataNascimento", "");
                }
            } catch (ParseException e) {
                obj.put("msgDataNascimento", "Data deve estar no formato yyyy-MM-dd");
            }
        }
        
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmarSenha");
        if (!confirmarSenha.equals(senha)) {
            obj.put("msgConfirmarSenha", "As senhas não são compatíveis");
        } else {
            obj.put("msgConfirmarSenha", "");
        }

        out.println(obj.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(ValidacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(ValidacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
