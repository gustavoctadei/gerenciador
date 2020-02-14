/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Gustavo
 */

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("Executando MonitoramentoFilter");
        
        long antes = System.currentTimeMillis();
        
        String acao = request.getParameter("acao");
        
        chain.doFilter(request, response);
        
        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execucao da acao " + acao + " -> " + (depois - antes));
    }
    
}
