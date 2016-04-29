package Aula04.main;

import Aula04.dao.DAO;
import Aula04.model.Crianca;
import Aula04.model.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 18/03/2016.
 */
/*
    Façam um programa para gerar a certidão de nascimento de um recém nascido (não sei por qual motivo tive essa ideia).
    O Registro do recém-nascido precisa dos seguintes documentos, a certidão de nascido vivo, RG dos pais.

    A certidão de nascido vivo é emitido pelo hospital, contendo nome do hospital,
    nome do recém nascido , nome dos pais, peso, data de nascimento e hora do parto.

    O RG possui nome dos pais, nome dos avós, numero de identificação.
    Dos pais também é necessário informa profissão e endereço.

    Essas informações devem ser fornecidas ao cartório que vai então gerar a certidão de nascimento.

    A certidão de nascimento é então  gerada com os dados de nascimento,
    dados dos pais e os nomes dos avós da criança, assim como a cidade de nascimento.

    Importante, o nome do pai não é obrigatório.

    Importante, já é possível em cartório registrar mais de uma mãe, ou mais de um pai.

    Crie um programa que, por meio de um vetor seja possível
    1 - cadastrar recém-nascidos,
    2 - buscar recém-nascido, pelo nome dele, Avos, ou pais,
    3 - mostrar quantos recém nascidos já foram cadastrado, e
    4 - quantos filhos uma determinada pessoa possui.
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Crianca> criancas = new ArrayList<>();
    static ArrayList<Pessoa> pais = new ArrayList<>();
    static ArrayList<Pessoa> maes = new ArrayList<>();

    public static void main(String[] args) {
        int opt=0;
        while(opt != 5){
            System.out.print("Menu \n" +
                    "1 - Cadastrar recém-nascido e pais \n" +
                    "2 - Buscar recém-nascido, pelo nome dele, avos, ou pais \n" +
                    "3 - Mostrar quantos recém nascidos já foram cadastrados \n" +
                    "4 - Quantos filhos uma determinada pessoa possui \n" +
                    "5 - Sair \n" +
                    "- Sua opção: ");
            opt= in.nextInt();
            switch (opt){
                case 1:{
                    DAO dao = new DAO();
                    dao.cadastraPais(pais, "PAI");
                    dao.cadastraPais(maes, "MÃE");
                    dao.cadastraBebe(criancas, pais, maes);
                    break;
                }
                case 2:{
                    DAO dao = new DAO();
                    dao.busca(criancas);
                    break;
                }

               case 3: {
                   DAO dao = new DAO();
                   dao.contagem(criancas);
                   break;
                }

                case 4:{
                    DAO dao = new DAO();
                    dao.buscaFilhos(criancas);
                    break;
                }
            }
        }
        System.out.println("Finalizando...");
    }
}
