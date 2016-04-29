package Aula03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 11/03/2016.
 */
/*
11 -  Crie um programa, usando vetores, classes e métodos em que: 
Contenha um menu com as seguintes possibilidades:
    Cadastrar novo funcionários
    Listar funcionarios
    Remover um funcionário
    Mostrar funcionário com o Menor Salário e com Maior
Os atributos dos funcionários são, nome, departamento, salário e idade.
 */

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Funcionario> funcs = new ArrayList<>();

    public static void main(String[] args) {
        int opt;
        do{
            System.out.print("Menu: \n"+
                    "- 1 - Cadastrar novo funcionário \n"+
                    "- 2 - Listar funcionários \n"+
                    "- 3 - Remover um funcionário \n"+
                    "- 4 - Mostrar funcionário com o menor salário e com maior \n"+
                    "- 5 - Sair \n"+
                    "- Sua opção: ");
            opt = in.nextInt();

            switch (opt){
                case 1:{
                    MetodosFuncionario.cadastraFuncionario();
                    break;
                }
                case 2:{
                    MetodosFuncionario.listarFuncionarios();
                    break;
                }
                case 3:{
                    MetodosFuncionario.apagarFuncionario();
                    break;
                }
                case 4:{
                    MetodosFuncionario.maiorMenorSalario();
                    break;
                }
            }
        }while(opt != 5);
        System.out.println("Fim...");
    }
}
