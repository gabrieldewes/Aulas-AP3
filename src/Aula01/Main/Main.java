package Aula01.Main;

import Aula01.Alunos.Aluno;
import Aula01.Funcionarios.Funcionario;

/**
 * Created by Gabriel on 26/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome("Gabriel");
        aluno.setCpf("039.546.290-89");
        aluno.setDataNasc("14/08/2016");
        System.out.println("Aluno "+ aluno.getNome()+", CPF: "+ aluno.getCpf()+", data de nascimento: "+aluno.getDataNasc());

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Caciano");
        aluno2.setCpf("123.456.788-09");
        aluno2.setDataNasc("09/09/2016");
        System.out.println("Aluno "+ aluno2.getNome()+", CPF: "+ aluno2.getCpf()+", data de nascimento: "+aluno2.getDataNasc());

        Funcionario func = new Funcionario();
        func.setNome("Adalberto");
        func.setSalario(456);
        System.out.println("Funcionário "+func.getNome()+", salário: R$ "+func.getSalario()+" reais.");

        Funcionario func2 = new Funcionario();
        func2.setNome("Alfredo");
        func2.setSalario(800);
        System.out.println("Funcionário "+func2.getNome()+", salário: R$ "+func2.getSalario()+" reais.");
    }
}
