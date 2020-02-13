/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        System.out.println("Logando " + login);
        
        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);
        
        if(usuario != null){
            System.out.println("Usuario existe");
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            
            //request.setAttribute("usuarioLogado", usuario);
            
            return "redirect:entrada?acao=ListaEmpresas";
        }
        
        else{
            return "redirect:entrada?acao=LoginForm";
        }
        
    }
    
}
