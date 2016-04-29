package Aula02;

/**
 * Created by Gabriel on 04/03/2016.
 */
public class Soma1Ate1000 {
    public static void main(String[] args) {
        int aux=0;
        for(int i=0; i<1000; i++){
            aux+=i;
        }
        System.out.println(aux);
    }
}
