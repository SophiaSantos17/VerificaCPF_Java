package com.mycompany.projeto01;
import java.util.Scanner;

public class Projeto01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-----------------");
        System.out.println("- VERIFICAR CPF -");
        System.out.println("-----------------\n");

        System.out.println("DIGITE SEU CPF: ");
        String cpf = entrada.next();

        // pegando apenas os 9 primeiros numeros do cpf, sem os dois digitos
        String cpfSemDig = cpf.substring(0, 9); // Extrai os nove primeiros dígitos

        // variavel para o resultado da somas
        double result = 0;

        // se o cpf tiver 11 numeros, comaça a rodar
        if (cpf.length() == 11){

            // loop para multiplicar os 9 numeros
            for (int i = 0; i < 9; i++) {
                int num = Character.getNumericValue(cpf.charAt(i)); // Converte o caractere para o valor numérico

                int factor = 10 - i; // Define o fator decrescente

                // multiplica o fator pelo numero
                int result_num = num * factor;
                // soma o resultado com o resultado da multiplicação
                result += result_num;
            }

            // variavel para armazenar o modulo
            double result_dig1 = result % 11;
            // transformando o double em inteiro
            int digito1_int = (int) result_dig1;

            if (digito1_int >= 2){
                digito1_int -= 11;
            }else{
                digito1_int = 0;
            }

            // transformando o inteiro em string
            String digito1_str = String.valueOf(digito1_int);

            // adicionando o primeiro digito no cpf sem o digito
            cpfSemDig += digito1_str;

            // deixando o resultado em 0
            result = 0;

            // msm loop porem para o segundo digito
            for (int i = 0; i < 10; i++) {
                int num = Character.getNumericValue(cpf.charAt(i)); // Converte o caractere para o valor numérico

                int factor = 11 - i; // Define o fator decrescente

                int result_num = num * factor;
                result += result_num;
            }

            double result_dig2 = result % 11;
            int digito2_int = (int) result_dig2;

            if (digito2_int >= 2){
                digito2_int -= 11;
            }else{
                digito2_int = 0;
            }

            String digito2_str = String.valueOf(digito2_int);

            cpfSemDig += digito2_str;

        }else{
            System.out.println("CPF INVÁLIDO!!!");
        }

        // tirando o ' - 'que vem com o numero
        cpfSemDig = cpfSemDig.replace("-", "");
        
        // verifica se o novo cpf for igual ao cpf digitado
        if (cpfSemDig.equals(cpf)){
            System.out.println("SEU CPF: " + cpf );
            System.out.println("CPF VERIFICADO: " + cpfSemDig);

        }else{ // se não for, invalida
            System.out.println("CPF INVÁLIDO");

        }
        
    }

}

