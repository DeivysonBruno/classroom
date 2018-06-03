# 
#
library(plyr)

rm(list = ls())

setwd("C:/Users/DeivysonBruno/Desktop/Testes Es")

dadosTeste1 <- read.csv2("teste1.txt")
dadosTeste2 <- read.csv2("teste2.txt")
View(dadosTeste1)
View(dadosTeste2)


dadosTeste1$melhor.resultado<-as.numeric(as.character.numeric_version(dadosTeste1$melhor.resultado))
dadosTeste1$pior.resultado<-as.numeric(as.character.numeric_version(dadosTeste1$pior.resultado))
dadosTeste1$tempo<-as.numeric(as.character.numeric_version(dadosTeste1$tempo))
##valores minimos e maximos
min(dadosTeste1$melhor.resultado)
max(dadosTeste1$melhor.resultado)
min(dadosTeste1$pior.resultado)
max(dadosTeste1$pior.resultado)
## desvio padrao para melhor e pior 
sd(dadosTeste1$melhor.resultado)
sd(dadosTeste1$pior.resultado)
## media de função objetivo 
mean(dadosTeste1$melhor.resultado)
mean(dadosTeste1$pior.resultado)
## media de tempo 
mean(dadosTeste1$tempo)


dadosTeste2$melhor.resultado<-as.numeric(as.character.numeric_version(dadosTeste2$melhor.resultado))
dadosTeste2$pior.resultado<-as.numeric(as.character.numeric_version(dadosTeste2$pior.resultado))
dadosTeste2$tempo<-as.numeric(as.character.numeric_version(dadosTeste2$tempo))
##valores minimos e maximos
min(dadosTeste2$melhor.resultado)
max(dadosTeste2$melhor.resultado)
min(dadosTeste2$pior.resultado)
max(dadosTeste2$pior.resultado)
## desvio padrao para melhor e pior 
sd(dadosTeste2$melhor.resultado)
sd(dadosTeste2$pior.resultado)
## media de função objetivo 
mean(dadosTeste2$melhor.resultado)
mean(dadosTeste2$pior.resultado)
## media de tempo 
mean(dadosTeste2$tempo)


