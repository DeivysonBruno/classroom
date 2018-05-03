/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadepratica1;

/**
 *
 * @author Bruno
 */
public class AtividadePratica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Problema problema = new Problema();

        Integer tamanho = 100;
        Double pCrossover = 0.01;
        Double pMutacao = 0.05;
        Double pCrossover1 = 0.015;
        Double pMutacao1 = 0.08;
        Integer geracoes = 300;
        
        Double minimo = -5.12;
        Double maximo = 5.12;
        Integer nVariaveis = 100;

        AlgoritmoGenetico ag1 = new AlgoritmoGenetico(tamanho, pCrossover, pMutacao, geracoes, problema, minimo, maximo, nVariaveis);
        AlgoritmoGenetico ag2 = new AlgoritmoGenetico(tamanho, pCrossover1, pMutacao1, geracoes, problema, minimo, maximo, nVariaveis);
        System.out.println("melhor resultado;pior resultado;tempo");
        
          
        
        for(int i=0;i<30;i++){
            
         ag1.executar();
       
        }
           
        
         for(int i=0;i<30;i++){
             
        ag2.executar();
        
        }
        
    }
    
}
