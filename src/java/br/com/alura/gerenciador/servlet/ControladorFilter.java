/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.Acao;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
//@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = {"/entrada"})
public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Executando ControladorFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

        String nome;

        try {
            Class classe = Class.forName(nomeDaClasse); //Carrega a classe com o nome da String
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e.getMessage());
        }

        String[] tipoEEndereco = nome.split(":");

        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);
        }
    }

    @Override
    public void init(FilterConfig fg) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
