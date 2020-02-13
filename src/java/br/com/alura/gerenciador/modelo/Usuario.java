/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.modelo;

/**
 *
 * @author Gustavo
 */
public class Usuario {
    
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean ehIgual(String login, String senha){
        if(!this.login.equals(login)){
            return false;
        }
        
        if(!this.senha.equals(senha)){
            return false;
        }
        
        return true;
    }
    
}
