package Aula02;

/**
 * Created by Gabriel on 04/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.nome = "Gabriel";
        f1.salario = 150;
        f1.recebeAumento(50);

        System.out.println("Salário atual:" + f1.salario);
        System.out.println("ganho anual:" + f1.calculaGanhoAnual());
        f1.mostra();
    }
}
