package Aula07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 08/04/2016.
 */
/*
    Faça um programa para cadastrar livros cada livro deve ser cadastrado na
    * biblioteca com titulo, editora, numero de paginas, autor e numero de exemplares.
    * Cada Autor possui nome, sobrenome e email para contato.
    * Todas as editoras possuem Nome, Enderenço para a correspondência e email.
    * A biblioteca precisa saber quantos Títulos cadastrados ela possui, quantos livros cadastrados.
    No programa será possível cadastra, remover e editar os livros.
    Devera ser possível também pesquisar livros informando editor, autor ou titulo do livro.
    Todas essas informações devem ser armazenadas em um vetor.
    É importante validar alguns dados, por exemplo o nome do autor deve ser apenas letras e não conter números,
    o titulo do livro obrigatoriamente deve possuir mais que 5 caracteres,
    o email deve possuir o @.{Você pode criar outras validações.}

 */
public class Main {
    public static ArrayList<Livro> biblioteca = new ArrayList<>();
    private static Lib lib = new Lib();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu=1;
        while (menu != 0) {
            System.out.print(
                    "| Biblioteca    |\n" +
                    "| 0 - Sair      |\n" +
                    "| 1 - Cadastrar |\n" +
                    "| 2 - Buscar    |\n" +
                    "| 3 - Mostrar   |\n" +
                    "| ");
            menu = in.nextInt();
            switch (menu) {
                case 1: {
                    biblioteca.add(lib.Leitor());
                    break;
                }
                case 2: {
                    lib.Buscador();
                    break;
                }
                case 3: {
                    lib.ListarLivros();
                    break;
                }
            }
        }
    }
}
