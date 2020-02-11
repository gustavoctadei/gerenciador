/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Banco {
    
    private static List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;
    
    static {
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Caelum");
        
        lista.add(empresa);
        lista.add(empresa2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.lista.add(empresa);
    }
    
    public void removeEmpresa(Integer id){
        
        Iterator<Empresa> it = lista.iterator();
        
        while (it.hasNext()){
            Empresa emp = it.next();
            if(emp.getId().equals(id)){
                it.remove();
            }
        }
    }
    
    public Empresa buscaEmpresaPelaId(Integer id){
        
        for (Empresa empresa : lista) {
            if(empresa.getId().equals(id)){
                return empresa;
            }
        }
        
        return null;
    }
    
    public List<Empresa> getEmpresas(){
        return Banco.lista;
    }
    
}
