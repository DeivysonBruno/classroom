/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atividadepratica1;
import java.lang.*;
/**
 *
 * @author fernando
 */
public class Problema {
    
    public void calcularFuncaoObjetivo(Individuo individuo) {
        
        Double soma = 10*individuo.getnVar().doubleValue();
       
        for( int i =0;i< individuo.getnVar();i++ ) {
            soma += (Math.pow(individuo.getVariaveis().get(i),2))-(10*Math.cos(2*3.14*individuo.getVariaveis().get(i)));
        }
       
        individuo.setFuncaoObjetivo(soma);
        
    }
    
}
