/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadepratica3;
import metodo.DEReal;
import problema.ProblemaRastringin;
import solucao.Individuo;

import solucao.IndividuoDouble;

/**
 *
 * @author DeivysonBruno
 */
public class AtividadePratica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Double minimo =-5.12;
        Double maximo = +5.12;
        int D =100;
        ProblemaRastringin problema = new ProblemaRastringin();
        int gmax=300;
        int Np =100;
        
        Double F = 0.001;
        Double Cr = 0.95;
        Double F2 = 0.001;
        Double Cr2 = 0.8;
        
        DEReal deReal = new DEReal(minimo,maximo,problema,gmax,D,Np,F,Cr);
        DEReal deReal2 = new DEReal(minimo,maximo,problema,gmax,D,Np,F2,Cr2);
        
        
        
        System.out.println("melhor resultado;pior resultado;tempo");
        
          
        
        for(int i=0;i<30;i++){
            
         Individuo melhor = deReal.executar();
       
        }
           
        System.out.println("melhor resultado;pior resultado;tempo");
        
         for(int i=0;i<30;i++){
        Individuo melhor2 = deReal2.executar();     
        
        
        }
        
        
        }
    
}
