/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo;

import java.util.Collections;
import java.util.Random;

import problema.ProblemaSchwefel;
import solucao.Individuo;
import solucao.IndividuoDouble;
import solucao.PopulacaoDouble;

/**
 *
 * @author Deivyson
 */
public class ESReal implements Metodo {

    // Parametros - problema - DeJong
    private Double minimo;
    private Double maximo;
    private Integer nVariaveis;
    private ProblemaSchwefel problema;
    
    // Parametros - ES
    private Integer mu; // Tamanho da populacao
    private Integer lambda; // numero de descendentes
    private Integer geracoes; // criterio de parada
    private Double pMutacao; // mutacao - aplicacao ao descendente - variacao/perturbacao
// parametros AG
    
    private Double pCrossover;
    
    public ESReal(Double minimo, Double maximo, Integer nVariaveis, ProblemaSchwefel problema, Integer mu, Integer lambda, Integer geracoes, Double pMutacao,Double pCrossover) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.nVariaveis = nVariaveis;
        this.problema =  problema;
        this.mu = mu;
        this.lambda = lambda;
        this.geracoes = geracoes;
        this.pMutacao = pMutacao;
        this.pCrossover=pCrossover;
        
    }
    
    @Override
    public IndividuoDouble executar() {
        int ind1, ind2, tamanho;
         long time1 = System.currentTimeMillis();

        // Geracao da populacao inicial - aleatoria - tamanho mu
        PopulacaoDouble populacao = new PopulacaoDouble( problema, minimo, maximo, nVariaveis, mu);     
        populacao.criar();
        
        // Avaliar
        populacao.avaliar();
        tamanho= populacao.getIndividuos().size();
        // Populacao - descendentes
        PopulacaoDouble descendentes = new PopulacaoDouble();
        PopulacaoDouble novaPopulacao = new PopulacaoDouble();
        Random rnd = new Random();
         // Criar a população
        

        // Criterio de parada - numero de geracoes
        for(int g = 1; g <= this.geracoes; g++) {
            
           
            // Para cada individuo, gerar lambda/mu descendentes
            for(int i = 0; i < populacao.getIndividuos().size(); i++) {
                
                // Gerar lambda/mu descendentes
                for(int d = 0; d < lambda / mu; d++) {
                    
                    // Clonar individuo
                    IndividuoDouble filho = (IndividuoDouble)populacao.getIndividuos().get(i).clone();
                    
                    // Aplicar mutacao
                    mutacaoPorVariavel(filho);
                    // Avaliar
                    problema.calcularFuncaoObjetivo(filho);
                    // Inserir na nova populacao
                    descendentes.getIndividuos().add(filho);
                    
                   
                }
                
            }
            
                 populacao.getIndividuos().clear();
            
            
            
        populacao.getIndividuos().addAll(descendentes.getIndividuos());
        Collections.sort(populacao.getIndividuos());
        //populacao.getIndividuos().subList(this.mu, populacao.getIndividuos().size()).clear();
       descendentes.getIndividuos().clear();
            for(int i = 0; i < populacao.getIndividuos().size(); i++)
            {
                // Crossover
                if (rnd.nextDouble() <= this.pCrossover) {
                    // Realizar a operação

                    ind1 = rnd.nextInt(populacao.getIndividuos().size());

                    do {
                        ind2 = rnd.nextInt(populacao.getIndividuos().size());
                    } while (ind1 == ind2);

                    IndividuoDouble desc1 = new IndividuoDouble(minimo, maximo, nVariaveis);
                    IndividuoDouble desc2 = new IndividuoDouble(minimo, maximo, nVariaveis);

                    // Progenitores
                    IndividuoDouble p1 = (IndividuoDouble) populacao.getIndividuos().get(ind1);
                    IndividuoDouble p2 = (IndividuoDouble) populacao.getIndividuos().get(ind2);

                    // Ponto de corte
                    int corte = rnd.nextInt(p1.getCromossomos().size());

                    // Descendente 1 -> Ind1_1 + Ind2_2;
                    crossoverUmPonto(p1, p2, desc1, corte);

                    // Descendente 2 -> Ind2_1 + Ind1_2;
                    crossoverUmPonto(p2, p1, desc2, corte);

                problema.calcularFuncaoObjetivo(desc1);
                    problema.calcularFuncaoObjetivo(desc2);

                    // Inserir na nova população
                    novaPopulacao.getIndividuos().add(desc1);
                    novaPopulacao.getIndividuos().add(desc2);
                
                }
            }
            
            // mu,lamb
              populacao.getIndividuos().addAll(novaPopulacao.getIndividuos());
            // Ordenar populacao;
            Collections.sort(populacao.getIndividuos());

            // Eliminar os demais individuos - criterio: tamanho da população
            populacao.getIndividuos()
                    .subList(tamanho,
                            populacao.getIndividuos().size())
                    .clear();

            // Limpa a nova população para a geração seguinte
            novaPopulacao.getIndividuos().clear();

       
       // System.out.println("G = " + g + "\t" + populacao.getMelhorIndividuo().getFuncaoObjetivo());
      
            
        }
        
    long time2 = System.currentTimeMillis();
      double seconds = (time2-time1);
       
        System.out.print(populacao.getIndividuos().get(0).getFuncaoObjetivo() +";"+seconds);
        System.out.println("");
        
    

    return (IndividuoDouble) populacao.getMelhorIndividuo();
        
    }
    
    private void crossoverUmPonto(IndividuoDouble ind1, IndividuoDouble ind2, IndividuoDouble descendente, int corte) {

        // Crossover aritmetico - 1 ponto de corte
        Random rnd = new Random();
        Double alpha = rnd.nextDouble();

        // Ind1_1
        // alpha * P1
        for (int i = 0; i < corte; i++) {
            Double valor = alpha * ind1.getCromossomos().get(i);
            descendente.getCromossomos().add(valor);
        }

        // Ind2_2
        // (1 - alpha) * P2
        for (int i = corte; i < this.nVariaveis; i++) {
            Double valor = (1.0 - alpha) * ind2.getCromossomos().get(i);
            descendente.getCromossomos().add(valor);
        }

    }
    
           private void mutacaoPorVariavel(Individuo individuo) {

        Random rnd = new Random();

        for (int i = 0; i < individuo.getCromossomos().size(); i++) {
            if (rnd.nextDouble() <= this.pMutacao) {

                // Mutacao aritmetica
                // Multiplicar rnd e inverter ou nao o sinal
                Double valor = (Double)individuo.getCromossomos().get(i);
                // Multiplica por rnd
                valor *= rnd.nextDouble();

                // Inverter o sinal
                if (!rnd.nextBoolean()) {
                    valor = -valor;
                }

                if (valor >= this.minimo
                        && valor <= this.maximo) {
                    individuo.getCromossomos().set(i, valor);

                }

            }
        }

    }

}


