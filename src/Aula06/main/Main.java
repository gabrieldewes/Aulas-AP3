package Aula06.main;

import Aula06.methods.Print;
import Aula06.methods.ramon;

/**
 * Created by Gabriel on 01/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        Print p = new Print();
        ramon r = new ramon();
        System.out.print("Informe qualquer coisa: ");
        Object obj = p.lerDado();
        System.out.println(obj);
    }
}
