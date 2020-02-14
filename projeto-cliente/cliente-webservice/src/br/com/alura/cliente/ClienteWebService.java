/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.cliente;

import java.io.IOException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Gustavo
 */
public class ClienteWebService {
    
    protected static ClienteWebService instance;
    
    public static ClienteWebService getInstance(){
        if (instance == null){
            instance = new ClienteWebService();
        }
        return instance;
    }
    
    public String executaCliente(String valor) throws IOException{
        
        String conteudo = Request
                .Post("http://localhost:8080/gerenciador/empresas")
                .addHeader("Accept", valor)
                .execute()
                .returnContent()
                .asString();
        
        return conteudo;
        
    }
    
}
