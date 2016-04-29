package Aula02;

/**
 * Created by Gabriel on 04/03/2016.
 */
/*
    Modele um funcionário. Ele deve ter o nome do funcionário, o departamento onde trabalha, seu salário (double),
    a data de entrada no banco (String) e seu RG (String).
    Você deve criar alguns métodos de acordo com sua necessidade. Além deles,
    crie um métodorecebeAumento que aumenta o salario do funcionário de acordo com o parâmetro passado como argumento.
    Crie também um método calculaGanhoAnual, que não recebe parâmetro algum, devolvendo o valor do salário multiplicado por 12..
    A ideia aqui é apenas modelar, isto é, só identifique que informações são importantes e o que um funcionário faz.
    Desenhe no papel tudo o que um Funcionario tem e tudo que ele faz.
 */
public class Funcionario {
    String nome;
    String dept;
    double salario;
    String dataIn;
    String rg;

    public void recebeAumento(double aumento){
        this.salario += aumento;
    }
    public double calculaGanhoAnual(){
        double aux=0;
        aux = this.salario*12;
        return aux;
    }
    public void mostra(){
        System.out.println("Nome: " + this.nome);
    }
}
