/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema;

import solucao.Individuo;
import solucao.IndividuoDouble;
import solucao.IndividuoInteger;

/**
 *
 * @author DeivysonBruno
 */
public class ProblemaSchwefel  {
    
    public ProblemaSchwefel(){}

    
    public void calcularFuncaoObjetivo(IndividuoDouble individuo) {
    
         Integer tam= individuo.getCromossomos().size();
        Double soma = 418.9829*individuo.getnVar().doubleValue();
       
        for( int i =0;i< individuo.getnVar();i++ ) {
            
            soma+=individuo.getCromossomos().get(i)*Math.sin(Math.sqrt(Math.abs(individuo.getCromossomos().get(i))));
           
        }
       
        individuo.setFuncaoObjetivo(soma);
            
 
    }

}
