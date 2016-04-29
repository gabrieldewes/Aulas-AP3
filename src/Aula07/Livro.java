package Aula07;

/**
 * Created by Gabriel on 08/04/2016.
 */
/*
titulo, editora, numero de paginas, autor e numero de exemplares.
 */
public class Livro {
    private String titulo;
    private String editora;
    private int num_paginas;
    private String autor;
    private int num_exemplares;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public int getNum_paginas() {
        return num_paginas;
    }
    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getNum_exemplares() {
        return num_exemplares;
    }
    public void setNum_exemplares(int num_exemplares) {
        this.num_exemplares = num_exemplares;
    }
}
