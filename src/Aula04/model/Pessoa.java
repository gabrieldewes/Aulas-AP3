package Aula04.model;

/**
 * Created by Gabriel on 19/03/2016.
 */
/*
O RG possui nome dos pais, nome dos avós, numero de identificação.
    Dos pais também é necessário informa profissão e endereço.
 */
public class Pessoa {
    String nome;
    String pai;
    String mae;
    String RG;
    String profissao;
    String endereco;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPai() {
        return pai;
    }
    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }
    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
