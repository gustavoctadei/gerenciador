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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "AlteraEmpresaServlet", urlPatterns = {"/alteraEmpresa"})
public class AlteraEmpresaServlet extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Alterando empresa");
        
        String nomeEmpresa = request.getParameter("nome");
        String fDataEmpresa = request.getParameter("data");
        
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        
        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(fDataEmpresa);
            
        } catch (ParseException ex) {
            throw new ServletException(ex);
        }
        
                Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        response.sendRedirect("listaEmpresas");
        
    }

}
