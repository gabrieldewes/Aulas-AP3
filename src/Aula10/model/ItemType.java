package Aula10.model;

/**
 * Created by gabriel on 01/05/16.
 */
public enum ItemType {
    LIVRO(1), EBOOK(2), CD(3), PENDRIVE(4), ELETRÔNICO(5), ACESSÓRIO(6);

    private final int valor;
    ItemType(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){ return valor; }

}
