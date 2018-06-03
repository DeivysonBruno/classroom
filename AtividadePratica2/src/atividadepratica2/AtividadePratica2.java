/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadepratica2;

import metodo.ESReal;
import problema.ProblemaRastringin;
import solucao.Individuo;

/**
 *
 * @author DeivysonBruno
 */
public class AtividadePratica2 {

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
        Double pMutacao = 0.05;
        
        
        Integer mu2 = 20;
        Integer lambda2 =100;
        Double pMutacao2 = 0.8;
        ProblemaRastringin problema2 = new ProblemaRastringin();
        
        
        ESReal esReal = new ESReal(minimo, maximo, nVariaveis, problema, mu, lambda, geracoes, pMutacao);
        ESReal esReal2 = new ESReal(minimo, maximo, nVariaveis, problema2, mu2, lambda2, geracoes, pMutacao2);
        
        
        System.out.println("melhor resultado;pior resultado;tempo");
        
          
        
        for(int i=0;i<30;i++){
            
         Individuo melhor = esReal.executar();
       
        }
           
        System.out.println("melhor resultado;pior resultado;tempo");
        
         for(int i=0;i<30;i++){
        Individuo melhor2 = esReal.executar();     
        
        
        }
        
        
        
       
       
        
// TODO code application logic here
    }
    
}
