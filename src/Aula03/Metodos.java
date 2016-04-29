package Aula03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gabriel on 11/03/2016.
 */
/*
1 – Elabore um método que retorne o tamanho da String passada por parâmetro.
2 - Elabore um método que mostre o   tamanho da String passada por parâmetro.
3 -  Elabore um método que receba duas strings passada por parâmetro concatene as duas e mostre a String concatenada e retorne o tamanho da String.
4 – Elabore um método que receba dois int e retorne a soma dos dois números.
5 – Elabore um método que receba dois int e retorne o maior valor;
6 – Elabore um método que receba duas Strings e retorne a string menor, se igual retorna a palavra igual;
7 – Elabore um método que receba duas Strings e retorne a string que vem primeiro na ordem alfabética, se igual retorna a palavra igual;
8 – Elabore um método que receba uma Strings e retorne a numero de vogais;
9 – Elabore um método que receba uma Strings e retorne a numero de consoantes;
10 – Elabore um método que receba uma Strings e retorne a numero de caracteres especiais;
 */
public class Metodos {

    public static int retornaTamanhoString(String str){
        return str.length();
    }

    public static void printaTamanhoString(String str){
        System.out.println("Tamanho da string: "+ str.length());
    }

    public static int concatenaString(String str, String str2){
        str.concat(str2);
        System.out.println("Strings concatenadas: "+ str);
        return str.length();
    }

    public static int soma(int n, int n2){
        return n+n2;
    }

    public static int retornaMaior(int n, int n2){
        int maior=0, menor=0;
        if (maior==0)
            maior = n;
        if(n2>maior)
            maior = n2;
        if(menor==0)
            menor=n;
        if(n2<menor)
            menor=n2;

        return maior;
    }

    public static String retornaStringMenor(String str, String str2){
        if(str.equals(str2)){
            return str;
        }else{
            int size = str.length();
            int size2 = str2.length();
            if(size > size2)
                return str;
            else
                return str2;
        }
    }

    public static String retornaStringOrdemAlfa(String str, String str2){
        Object[] data = {str, str2};
        List list = Arrays.asList(data);
        Collections.sort(list);
        str = list.get(0).toString();
        System.out.println("Nome que vem antes na ordem alfabética: "+ str);
        return str;
    }

    public static int retornaNumeroVogais(String str){
        return str.replaceAll("[^aeiouAEIOU]","").length();
    }

    public static int retornaNumeroConsoantes(String str){
        return str.replaceAll("[^bcdfghjklmnpqrstvxwyzBCDFGHJKLMNPQRSTVXWYZ]","").length();
    }

    public static int retornaNumeroEspeciais(String str){
        return str.length() - str.replaceAll("[^0123456789aeioubcdfghjklmnpqrstvxwyzAEIOUBCDFGHJKLMNPQRSTVXWYZ]","").length();
    }

}
