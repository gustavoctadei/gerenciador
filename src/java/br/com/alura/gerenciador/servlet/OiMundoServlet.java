/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        PrintWriter out =  resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Oi mundo, parabens. Voce escreveu seu primeiro servlet");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("O servlet OiMundoServlet foi chamado.");
    }
}
