package Aula06.methods;

import java.util.Random;

/**
 * Created by Gabriel on 01/04/2016.
 */
public class ramon {

    public boolean isPositive(float numero){
        return numero>=0;
    }

    public boolean isZero(float numero){
        return numero==0;
    }

    public float delta(float a, float b, float c){
        return ((b*b) - 4*(a*c));
    }

    public float menor(float a, float b){
        float menor=0, maior=0;
        if (menor ==0)
            menor = a;
        if (menor < b)
            menor = b;
        if(maior == 0)
            maior = a;
        if (maior > b)
            maior = b;
        return menor;
    }

    public float maior(float a, float b){
        float menor=0, maior=0;
        if (menor == 0)
            menor = a;
        if (menor < b)
            menor = b;
        if(maior == 0)
            maior = a;
        if (maior > b)
            maior = b;
        return maior;
    }

    public float retornaMaior(float a, float b, float c){
        float maior = Math.max(a, b);
        maior = Math.max(maior, c);
        return maior;
    }

    public float retornaMenor(float a, float b, float c){
        float maior = Math.min(a, b);
        maior = Math.min(maior, c);
        return maior;
    }

    public int numeroRandom(){
        Random gerador = new Random();
        return gerador.nextInt(10);
    }

    public int numeroRandomMax(int max){
        Random gerador = new Random();
        return gerador.nextInt(max);
    }
}
