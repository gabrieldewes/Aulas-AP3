package Aula04.dao;

import Aula04.model.Crianca;
import Aula04.model.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 19/03/2016.
 */
public class DAO {
    static Scanner in = new Scanner(System.in);

    public ArrayList<Pessoa> cadastraPais(ArrayList<Pessoa> pessoas, String id){
        String c="s";
        while(c.contentEquals("s")){
            Pessoa ps = new Pessoa();
            System.out.println("Cadastro de novo(a) "+ id +": ");
            System.out.print("Nome: ");
            ps.setNome(in.nextLine());
            System.out.print("RG: ");
            ps.setRG(in.nextLine());
            System.out.print("Nome do Pai: ");
            ps.setPai(in.nextLine());
            System.out.print("Nome da Mãe: ");
            ps.setMae(in.nextLine());
            System.out.print("Endereço: ");
            ps.setEndereco(in.nextLine());
            System.out.print("Profissão: ");
            ps.setProfissao(in.nextLine());

            pessoas.add(ps);

            System.out.print("Deseja cadastrar outro(a) "+ id +"? S/N: ");
            c=in.nextLine();
        }
        return pessoas;
    }

    public ArrayList<Crianca> cadastraBebe(ArrayList<Crianca> criancas, ArrayList<Pessoa> pai, ArrayList<Pessoa> mae){
        String c="s";
        while(c.contentEquals("s")){
            Crianca cr = new Crianca();
            System.out.println("Cadastro do rescém-nascido: ");
            System.out.print("Nome: ");
            cr.setNome(in.nextLine());
            System.out.print("Peso: ");
            cr.setPeso(in.nextDouble());
            System.out.print("Data e Hora do nascimento: ");
            in.nextLine();
            cr.setDataHora(in.nextLine());
            for(Pessoa ps:pai){
                cr.setPai(ps.getNome());
                cr.setVoPat(ps.getPai());
                cr.setAvoPat(ps.getMae());
            }
            for(Pessoa ps:mae){
                cr.setMae(ps.getNome());
                cr.setVoMat(ps.getPai());
                cr.setAvoMat(ps.getMae());
            }

            criancas.add(cr);

            System.out.println("Parabéns! "+ cr.getNome() +" cadastrado(a) com sucesso. " +
            "\nCadastrar outra criança? S/N: ");
            c=in.nextLine();
        }
        return criancas;
    }

    public void busca(ArrayList<Crianca> criancas){
        boolean ok=true;
        System.out.print("Informe algum nome para buscar: ");
        String nome = in.nextLine();
        for(Crianca cr:criancas){
            if(cr.getNome().contentEquals(nome) ||
                    cr.getPai().contentEquals(nome) ||
                    cr.getMae().contentEquals(nome) ||
                    cr.getVoMat().contentEquals(nome) ||
                    cr.getAvoMat().contentEquals(nome) ||
                    cr.getVoPat().contentEquals(nome) ||
                    cr.getAvoPat().contentEquals(nome)){

                System.out.print("\nCriança encontrada; \n" +
                                    "Nome: "+ cr.getNome() +
                                    "\nPais: "+ cr.getPai() +" e "+ cr.getMae() +". \n\n");
                ok = false;
            }
        }
        if(ok)
            System.out.println("Nenhuma criança encontrada. Revise o nome digitado.");
    }

    public void contagem(ArrayList<Crianca> cr){
        System.out.println("\nTemos um total de "+ cr.size() +" criança(s) cadastradas. \n");
    }

    public void buscaFilhos(ArrayList<Crianca> criancas){
        boolean ok=true;
        int i=0;
        System.out.print("Informe o nome da pessoa: ");
        String nome = in.nextLine();
        for(Crianca cr:criancas){
            if(cr.getPai().contentEquals(nome) ||
                    cr.getMae().contentEquals(nome)){
                ok=false;
                i++;
            }
        }
        if(ok)
            System.out.println("Esta pessoa não possui nenhum filho registrado. ");
        else
            System.out.println("\n"+ nome +" tem "+ i +" filho(s). ");
        for(Crianca cr:criancas){
            if(cr.getPai().contentEquals(nome) ||
                    cr.getMae().contentEquals(nome)){
                System.out.println("Nome: "+ cr.getNome());
            }
        }
        System.out.println();
    }
}
