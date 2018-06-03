/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecmodel;
import metodo.ESReal;


import solucao.Individuo;
import problema.ProblemaRastringin;

/**
 *
 * @author DeivysonBruno
 */
public class ESRealMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        Double minimo = -5.12;
        Double maximo = 5.12;
        Integer nVariaveis = 100;
        ProblemaRastringin problema = new ProblemaRastringin();
        
        Integer mu = 20;
        Integer lambda =100;
        Integer geracoes = 300;
        Double pMutacao = 0.8;
        
        ESReal esReal = new ESReal(minimo, maximo, nVariaveis, problema, mu, lambda, geracoes, pMutacao);
        
        Individuo melhor = esReal.executar();
        
        System.out.println(melhor);
       

    }
    
}
