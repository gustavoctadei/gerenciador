/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "EmpresasService", urlPatterns = {"/empresas"})
public class EmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Empresa> empresas = new Banco().getEmpresas();
        
        String valor = request.getHeader("accept");
        
        if(valor.contains("json")){
            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            response.setContentType("application/json");
            response.getWriter().print(json);
        }
        
        else if(valor.contains("xml")){
            XStream xstream = new XStream();
            xstream.alias("Empresa", Empresa.class);
            String xml = xstream.toXML(empresas);

            response.setContentType("application/xml");
            response.getWriter().print(xml);  
        }
        
        else{
            response.setContentType("application/json");
            response.getWriter().print("{'message':'no content'}");
        }

    }
}
