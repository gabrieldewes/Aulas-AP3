package Aula03;

/**
 * Created by Gabriel on 11/03/2016.
 */
public class Test {
    public static void main(String[] args) {
        String str = "123...abc;;;";
        int a = str.length() - str.replaceAll("[^0123456789aeioubcdfghjklmnpqrstvxwyzAEIOUBCDFGHJKLMNPQRSTVXWYZ]","").length();
        System.out.println(a);
    }
}
