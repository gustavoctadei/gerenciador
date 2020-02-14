/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class ListaEmpresas implements Acao{
    
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();
        
        request.setAttribute("empresas", lista);
        
        return "forward:listaEmpresas.jsp";
        
    }
    
}
