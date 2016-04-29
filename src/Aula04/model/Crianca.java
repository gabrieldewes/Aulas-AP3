package Aula04.model;


/**
 * Created by Gabriel on 19/03/2016.
 */
/*
A certidão de nascido vivo é emitido pelo hospital, contendo nome do hospital,
    nome do recém nascido , nome dos pais, peso, data de nascimento e hora do parto.
 */
public class Crianca {
    String nome;
    String pai;
    String voPat;
    String avoPat;
    String mae;
    String voMat;
    String avoMat;
    Double peso;
    String dataHora;

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

    public String getVoPat() {
        return voPat;
    }
    public void setVoPat(String voPat) {
        this.voPat = voPat;
    }

    public String getAvoPat() {
        return avoPat;
    }
    public void setAvoPat(String avoPat) {
        this.avoPat = avoPat;
    }

    public String getMae() {
        return mae;
    }
    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getVoMat() {
        return voMat;
    }
    public void setVoMat(String voMat) {
        this.voMat = voMat;
    }

    public String getAvoMat() {
        return avoMat;
    }
    public void setAvoMat(String avoMat) {
        this.avoMat = avoMat;
    }

    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
