/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import problema.Problema;
import solucao.Individuo;

/**
 *
 * @author DeivysonBruno
 */
public class BuscaLocalCombinatorio {
    Problema problema;
    
    public void executar (Individuo individuo){
    
        ArrayList<Integer> operacoes = new ArrayList<>(Arrays.asList(1,2,4));
        Collections.shuffle(operacoes);
        for(Integer i:operacoes){
            
            switch (i){
            
                case 1:
                    buscaLocalRemoverUV(individuo);
                    break;
                case 2:
                    buscaLocalRemoverUXaposV(individuo);
                    break;
                case 4:
                    buscaLocalSwap(individuo);
                    break;
                    
            }
            
        }
    
        
    }

    public BuscaLocalCombinatorio(Problema problema) {
        this.problema = problema;
    }
    //troca U e V
    // first improvement
    public void buscaLocalSwap (Individuo individuo) {
        // custo atual
        
        Double foAtual = individuo.getFuncaoObjetivo();
        for(int u =0; u<individuo.getCromossomos().size()-1;u++){
            for(int v= u+1; v < individuo.getCromossomos().size();v++){
            //swap u e v
            Collections.swap(individuo.getCromossomos(), u, v);
            // calcular diferença
            problema.calcularFuncaoObjetivo(individuo);
            
            if(individuo.getFuncaoObjetivo() < foAtual){
            // encerrar 
            return;
            }else {
            // desfazer a troca 
            Collections.swap(individuo.getCromossomos(),u,v);
            // retorna fo
            individuo.setFuncaoObjetivo(foAtual);
            }
            
            }
        }
    }
    
    //Remover u e inserir apos v
    
    public void buscaLocalRemoverUV(Individuo individuo){
    
        Double foAtual= individuo.getFuncaoObjetivo();
        for(int u=0;u<individuo.getCromossomos().size()-1;u++){
            for(int v=0; v< individuo.getCromossomos().size();v++){
                //recuperar valor em u 
                Integer valorU=(Integer)individuo.getCromossomos().get(u);
                
                // remover u 
                individuo.getCromossomos().remove(u);
                //inserir apos v
                individuo.getCromossomos().add(v,valorU);
                
                // calcular custo
                problema.calcularFuncaoObjetivo(individuo);
                
                if(individuo.getFuncaoObjetivo() < foAtual){
                
                    // encerrar 
                    return;
                }else {
                    //desfazer troca 
                    individuo.getCromossomos().remove(v);
                    
                    individuo.getCromossomos().add(u,valorU);
                    individuo.setFuncaoObjetivo(foAtual);
                    
                }
            }
        }
    }
    public void buscaLocalRemoverUXaposV(Individuo individuo){
    
        Double foAtual = individuo.getFuncaoObjetivo();
        for(int u=0;u< individuo.getCromossomos().size()-2;u++){
            int x= u+1;
            for(int v=x+1; v< individuo.getCromossomos().size();v++){
            
                Integer valorU= (Integer)individuo.getCromossomos().get(u);
                Integer valorX = (Integer)individuo.getCromossomos().get(x);
                Integer valorV = (Integer)individuo.getCromossomos().get(v);
                
                //remover u e x 
                individuo.getCromossomos().remove(x);
                individuo.getCromossomos().remove(u);
                
                //inserir x e u apos v
                
                individuo.getCromossomos().add(v-1, valorU);
                individuo.getCromossomos().add(v, valorX);
                
                problema.calcularFuncaoObjetivo(individuo);
                
                if(individuo.getFuncaoObjetivo()<foAtual){
                    //encerra 
                    return;
                }else{
                    //desfaz inserçoes 
                    //remover u x 
                    individuo.getCromossomos().remove(valorU);
                    individuo.getCromossomos().remove(valorX);
                    
                    // inserir u e x nas posiçoes originais 
                    
                    individuo.getCromossomos().add(u, valorU);
                    individuo.getCromossomos().add(x, valorX);
                    
                    individuo.setFuncaoObjetivo(foAtual);
                }
                
                
            }
            
        }
        
    }
}
