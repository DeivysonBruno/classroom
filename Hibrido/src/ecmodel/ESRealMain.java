/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecmodel;
import metodo.ESReal;


import solucao.Individuo;
import problema.ProblemaSchwefel;

/**
 *
 * @author DeivysonBruno
 */
public class ESRealMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        Double minimo = -500.0;
        Double maximo = 500.0;
        Integer nVariaveis = 50;
        ProblemaSchwefel problema = new ProblemaSchwefel();
        
        Integer mu = 100;
        Integer lambda =200;
        Integer geracoes = 300;
        Double pMutacao = 0.001;
        Double pCrossover= 0.3;
        
        ESReal esReal = new ESReal(minimo, maximo, nVariaveis, problema, mu, lambda, geracoes, pMutacao,pCrossover);
        for (int i =0; i<30;i++){
            System.out.print((i+1)+";");
        Individuo melhor = esReal.executar();
        
        }
       

    }
    
}
