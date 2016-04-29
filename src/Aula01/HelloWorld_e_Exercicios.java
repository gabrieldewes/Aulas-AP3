package Aula01;

import java.util.Scanner;

/**
 * Created by Gabriel on 26/02/2016.
 */
public class HelloWorld_e_Exercicios {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello World!");

        /*
        4.	Faça um programa Que imprima a soma de duas variáveis definidas e mostre o resultado na tela
         */
        int a=10; int b=20;
        System.out.println("Soma dos valores "+ a +" + "+ b +" é igual a "+ (a+b));
        /*
        5.	Que imprima a divisão de duas variáveis definidas e mostre o resultado na tela
         */
        System.out.println("Divisão dos valores "+ a +" / "+ b +" é igual a "+ (a/b));

        /*
        6.	Faça um programa que mostre todos os números num
        intervalo entre duas variáveis pré-estabelecidas.
        Faça o programa usando os 3 laços de repetição
         */
        System.out.println("Intervalo entre as variáveis "+ a +" e "+ b +" é ");
        System.out.println("Utilizando laço For");
        for(int i=0; i<a; i++){
            System.out.print((a+i) +" - ");
        }

        System.out.println("\nUtilizando laço Do-While");
        do{
            System.out.print((a) +" - ");
            a++;
        }while(a<b);

        System.out.println("\nUtilizando laço While");
        a=10;
        while(a<b){
            System.out.print((a) +" - ");
            a++;
        }
        /*
        7.	Faça um programa com 3 variaves,
        1 byte, 1 long e 1 float,
        atribua o valor 100 pra variável do tipo byte e
        faça cast para byte -> long -> float  .
        Mostre o valor da variável em float.
         */
        System.out.println("\n\nExercicio 7");
        byte byt=100;
        long lon;
        float floa;

        lon = (byte) byt;
        floa = (long) byt;
        System.out.println("byte: "+ byt +" // long: "+ lon +" // float: "+ floa);

        /*
        8.	Faça um programa que calcule a media, que é
        composta de 3 notas com o peso máximo 10.
        O programa deve calcular a nota até o usuário informar 3 notas Zero.
         */
        int j=0, n=3;
        float[] notas = new float[n];
        float media=0;
        do{
            System.out.println("Informe suas 3 notas: ");
            for(int i=0; i<n; i++){
                notas[i] = in.nextFloat();
                if(notas[i] == 0)
                    j++;
                else
                    media=media+notas[i];
            }
            media=media/n;
            if(j!=3)
                System.out.println("A média do aluno foi de "+ media+".");
        }while(j<n);
        System.out.println("Fim");
    }
}
