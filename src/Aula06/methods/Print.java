package Aula06.methods;

import java.util.Scanner;

/**
 * Created by Gabriel on 01/04/2016.
 */
public class Print {
    static Scanner in = new Scanner(System.in);
    private Object dado;

    public int lerInt(){
        System.out.println("Informe um número inteiro: ");
        return in.nextInt();
    }

    public Float lerFloat(){
        System.out.println("Informe um número real: ");
        Float f = in.nextFloat();
        return f;
    }

    public String lerString(){
        System.out.println("Informe uma palavra: ");
        return in.nextLine();
    }

    public Object lerDado(){
        try{
            dado = in.next();
        }catch (Exception e){
            try{
                dado = in.nextInt();
            }catch (Exception b){
                dado  = in.nextFloat();
            }
        }
        return dado;
    }
}
