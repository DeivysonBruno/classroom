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
public class ProblemaRastringin  {
    
    public ProblemaRastringin(){}

    
    public void calcularFuncaoObjetivo(IndividuoDouble individuo) {
    
         Integer tam= individuo.getCromossomos().size();
        Double soma = 10*(tam.doubleValue());
       
        for( int i =0;i< tam;i++ ) {
            soma += (Math.pow(individuo.getCromossomos().get(i),2))-(10*Math.cos(2*3.14*individuo.getCromossomos().get(i)));
        }
       
        individuo.setFuncaoObjetivo(soma);
            
 
    }

}
