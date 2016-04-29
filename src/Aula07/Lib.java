package Aula07;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Gabriel on 17/04/2016.
 */
public class Lib extends Main {
    static Scanner in = new Scanner(System.in);
    public Livro Leitor() {
        in.useLocale(Locale.US);
        System.out.print("Título: ");
        String title = in.nextLine();
        while (title.isEmpty() || title.contentEquals(" ") || title.length()<5) {
            in.nextLine();
            System.out.print("Deve conter ao mínimo 5 caracteres. Informe novamente: ");
            title = in.nextLine();
        }
        System.out.print("Editora: ");
        String edit = in.nextLine();
        while (stringDontHaveDigit(edit)) {
            in.nextLine();
            System.out.print("Informe novamente: ");
            edit = in.nextLine();
        }
        System.out.print("Autor: ");
        String aut = in.nextLine();
        while (stringDontHaveDigit(aut)) {
            in.nextLine();
            System.out.print("Informe novamente: ");
            aut = in.nextLine();
        }
        System.out.print("Número de páginas: ");
        int num_pag = in.nextInt();
        while (isZero(num_pag)) {
            System.out.print("Informe novamente: ");
            num_pag = in.nextInt();
        }
        System.out.print("Número de exemplares: ");
        int num_ex = in.nextInt();
        while (isZero(num_ex)) {
            System.out.print("Informe novamente: ");
            num_ex = in.nextInt();
        }
        return this.CadastraLivro(title, edit, num_pag, aut, num_ex);
    }

    private Livro CadastraLivro(String title, String edit, int n_pag, String aut, int n_ex){
        Livro l = new Livro();
        l.setTitulo(title);
        l.setEditora(edit);
        l.setNum_paginas(n_pag);
        l.setAutor(aut);
        l.setNum_exemplares(n_ex);
        return l;
    }

    public void Buscador(){
        boolean nao_encontrado = true;
        System.out.print("- Informe título/editora/autor para buscar: ");
        String search = in.next();
        for (Livro livro : biblioteca) {
            if ((livro.getTitulo().contentEquals(search)) ||
                    (livro.getAutor().contentEquals(search)) ||
                    (livro.getEditora().contentEquals(search))) {
                nao_encontrado = false;
                System.out.println("--|| Informações sobre o livro ||--");
                System.out.print(livro.getTitulo() + ", autor: " + livro.getAutor() + " da editora " + livro.getEditora() +"\n");
                int acao = 1;
                while (acao != 0) {
                    System.out.print("Sair - 0 \n" +
                            "Alterar - 1 \n" +
                            "Apagar - 2: ");
                    acao = in.nextInt();
                    switch (acao) {
                        case 1: {
                            this.AlteraLivro(livro);
                            acao=0;
                            break;
                        }
                        case 2: {
                            this.ApagaLivro(livro);
                            acao=0;
                            break;
                        }
                    }
                }

            }
            if (!nao_encontrado) break;

        }
        if (nao_encontrado)
            System.out.println("Livro não encontrado. \n");
        else
            System.out.println("Retornando ao menu...");
    }

    public void ListarLivros(){
        for (Livro l:biblioteca) {
            System.out.println("--|| "+ l.getTitulo() +", autor: "+ l.getAutor() +", da editora "+ l.getEditora()+ " ||--");
        }
        System.out.println("--|| Esta biblioteca tem um total de "+ biblioteca.size() +" livros. ||--");
    }

    public void AlteraLivro(Livro livro) {
        for (Livro l:biblioteca) {
            if (l.equals(livro)){
                biblioteca.set(biblioteca.indexOf(livro), this.Leitor());
                break;
            }
        }

    }

    public void ApagaLivro(Livro livro) {
        for (Livro l:biblioteca) {
            if (l.equals(livro)) {
                System.out.println(l.getTitulo() +" apagado. ");
                biblioteca.remove(livro);
                break;
            }
        }
    }

    private boolean stringDontHaveDigit(String str) {
        if (str.isEmpty() || str.contentEquals(" ")) {
            System.out.print("Campo vazio. ");
            return true;
        }
        if (str.matches("^[0-9]*$")) {
            System.out.println("Este campo não pode conter números. ");
            return true;
        }
        boolean containsDigit = false;
        for (int i=0; i<str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                containsDigit = true;
                System.out.println("Este campo não pode conter números. ");
                break;
            }
        }
        return containsDigit;
    }

    private boolean isZero(int n) {
        if (n < 1) {
            System.out.print("Campo zerado. ");
            return true;
        }
        return false;
    }
}
