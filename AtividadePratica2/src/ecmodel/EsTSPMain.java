/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecmodel;

import metodo.EsTSP;
import problema.Problema;
import problema.ProblemaTSP;
import solucao.Individuo;

/**
 *
 * @author DeivysonBruno
 */
public class EsTSPMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Problema problema= new ProblemaTSP("/C:\\Users\\DeivysonBruno\\Desktop\\computação evolucionaria\\instances\\tsplib\\berlin52.tsp");
        
        //parametros
        Integer mu=20;
        Integer lambda=100;
        Integer geracoes=1000;
        Double pMutacao = 0.01;
        Double PBuscaLocal=0.8;
        
        EsTSP esTsp= new EsTSP(problema, mu, lambda, geracoes, pMutacao, PBuscaLocal);
        Individuo melhor = esTsp.executar();
        
        System.out.println(melhor);
    }
    
}
