package Aula03;

import java.util.Iterator;

/**
 * Created by Gabriel on 15/03/2016.
 */
public class MetodosFuncionario extends Main{

    public static void cadastraFuncionario(){
        String c;
        do{
            System.out.println("Funcionário "+ funcs.size() +"; \n"+
            "Informe o nome: ");
            in.nextLine();
            String nome = in.nextLine();
            System.out.println("Departamento: ");
            String dept = in.nextLine();
            System.out.println("Salário: ");
            double salario = in.nextFloat();
            System.out.println("Idade: ");
            int idade = in.nextInt();

            Funcionario func = new Funcionario();
            func.setNome(nome);
            func.setDept(dept);
            func.setSalario(salario);
            func.setIdade(idade);
            funcs.add(func);

            System.out.println("Continuar? s/n");
            c = in.next();
        }while(c.contentEquals("s"));
    }

    public static void listarFuncionarios(){
        for(Funcionario func:funcs){
            System.out.println("Nome: "+ func.getNome() +", idade: "+ func.getIdade());
            System.out.println("Departamento: "+ func.getDept() +", salário: "+ func.getSalario() +"\n");
        }
    }

    public static void apagarFuncionario(){
        String erro = "Funcionário não encontrado. Verifique o nome digitado e tente novamente.";
        String okay = "Funcionário removido.";
        String informe = "Informe o nome do funcionário que deseja remover: ";
        boolean ok=false;

        System.out.println(informe);
        in.nextLine();
        String nome = in.nextLine();

        Iterator<Funcionario> it = funcs.iterator();
        while(it.hasNext()){

            if(it.next().getNome().contentEquals(nome)){
                it.remove();
                ok = true;
                System.out.println(okay);
            }
        }
        if(!ok)
            System.out.println(erro);
    }

    public static void maiorMenorSalario(){
        double maior=0, menor=0;
        int idMaior=0, idMenor=0;
        for(Funcionario func:funcs){
            if(maior==0) {
                maior = func.getSalario();
                idMaior = funcs.indexOf(func);
            }
            if(func.getSalario() > maior) {
                maior = func.getSalario();
                idMaior = funcs.indexOf(func);
            }
            if(menor==0) {
                menor = func.getSalario();
                idMenor = funcs.indexOf(func);
            }
            if(func.getSalario() < menor) {
                menor = func.getSalario();
                idMenor = funcs.indexOf(func);
            }
        }
        System.out.println("Funcionário "+ funcs.get(idMaior).getNome() +" tem o maior salário. R$ "+ maior +" reais.");
        System.out.println("Funcionário "+ funcs.get(idMenor).getNome() +" tem o menor salário. R$ "+ menor +" reais.");
    }
}
