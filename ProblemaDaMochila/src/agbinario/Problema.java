/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agbinario;

/**
 *
 * @author fernando
 */
public class Problema {
    public Problema(Double capacidade){
    this.capacidade=capacidade;
    
    }
   private Double capacidade;
    public void calcularFuncaoObjetivo(Individuo individuo) {
        
        Double soma = 0.0;
        
        
        
        for( int i=0;i<individuo.getnVar();i++ ) {
            soma += individuo.getCromossomos().get(i)*Math.pow(individuo.getPesos().get(i), 2);
                
        }
        
        
        individuo.setFuncaoObjetivo(soma);
        
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }
    
}
