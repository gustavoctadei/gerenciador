/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "UnicaEntradaServlet", urlPatterns = {"/entrada"})
public class UnicaEntradaServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String paramAcao = request.getParameter("acao");
        
        if(paramAcao.equals("ListaEmpresas")){            
            ListaEmpresas acao = new ListaEmpresas();
            acao.executa(request, response);
        }
        
        else if(paramAcao.equals("RemoveEmpresa")){
            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(request, response);
        }
        
        else if(paramAcao.equals("MostraEmpresa")){
            MostraEmpresa acao = new MostraEmpresa();
            acao.executa(request, response);
        }
        
        else if(paramAcao.equals("AlteraEmpresa")){
            AlteraEmpresa acao = new AlteraEmpresa();
            acao.executa(request, response);
        }
        
        else if(paramAcao.equals("NovaEmpresa")){
            NovaEmpresa acao = new NovaEmpresa();
            acao.executa(request, response);
        }
        
    }
    
}
