package imc;

import java.util.Locale;
import java.util.Scanner;

/*
DESCRIÇÃO:
Esse programa tem o objetivo de calcular o IMC (Índice de Massa Corporal),
um tipo de cálculo que é usado pelas pessoas para saber se estão em um peso
ideal para sua saúde.
*/

public class IMC {
    
    // Metodo responsável por calcular o IMC com os dados descritos
    public static double calcularIMC(double peso, double altura){
        // IMC = peso/(altura^2)
        return peso/Math.pow(altura, 2);
    }
    
    public static String obterEstado(double imc){
        if(imc < 18.5){
            return "Abaixo do peso";
            
        }else if(imc < 24.9){
            return "Peso normal";
            
        }else if(imc < 29.9){
            return "Sobrepeso";
        
        }else if(imc < 34.9){
            return "Obesidade grau 1";
            
        }else if(imc < 39.9){
            return "Obesidade grau 2";
            
        }else{
            return "Obesidade grau 3";
        }
    }
    
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        /*
        Ao digitar valores de ponto flutaunte(números reais) serão considerados
        somente números inseridos com .(ponto) e não com ,(virgula).
        */
        
        //Definindo algumas variaveis
        Scanner input = new Scanner(System.in);
        double peso, altura, imc = 0;
        boolean repeticao = true; 
        
        // Apresentando o programa
        System.out.println("IMC");
        System.out.println("Programa de calculo do IMC (Índice de Massa Corporal)");
        System.out.println();
        
        // Laço para recebimento de dados
        do{
            try{
                // Inserindo dados necessários
                System.out.print("Digite seu PESO (em kilogramas): ");
                peso = input.nextDouble();

                System.out.print("Digite sua ALTURA (em metros): ");
                altura = input.nextDouble();

                imc = calcularIMC(peso, altura);

                if(imc < 0){
                    // Erros de digitação podem fazer o imc ficar com valor negativo
                    throw new Exception();
                }
                
                // Quando todos os dados são colocados de forma correta, o laço é interrompido
                repeticao = false; 
                
            }catch(Exception e){
                // Exceção aplicada a possiveis erros de digitação
                System.out.println();
                System.out.println("Erro: dados digitados incorretamente");
                System.out.println("Tente inserir novamente");
                System.out.println();
                input.next();
            }
        }while(repeticao);

        System.out.println();
        System.out.println("O IMC foi de: " + String.format("%.2f", imc));
        System.out.println("Estado: " + obterEstado(imc));
    }
}
