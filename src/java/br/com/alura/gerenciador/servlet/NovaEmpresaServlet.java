/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "NovaEmpresaServlet", urlPatterns = {"/novaEmpresa"})
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Cadastrando nova empresa");
        
        String nomeEmpresa = request.getParameter("nome");
        String fDataEmpresa = request.getParameter("data");
        
        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(fDataEmpresa);
            
        } catch (ParseException ex) {
            throw new ServletException(ex);
        }
        
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        request.setAttribute("empresa", empresa.getNome()); //Setar atributo a ser enviado p/ o JSP
        response.sendRedirect("listaEmpresas");
        
//        //Chamar o JSP
//        RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp"); //Aponta o Caminho
//        request.setAttribute("empresa", empresa.getNome()); //Setar atributo a ser enviado p/ o JSP
//        rd.forward(request, response); //Redireciona
    }

}
