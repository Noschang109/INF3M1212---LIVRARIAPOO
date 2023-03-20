/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the livro.
 */
package controller;

import inf3m212.livrariapoo.INF3M212LivrariaPOO;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author jbferraz
 */
public class CLivro {

    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    /**
     * geraID gerencia a geração de id's autoincrement para Livro.
     *
     * @return
     */
    public int geraID() {
        return this.idLivro++;
    }

    /**
     * addLivro adiciona um livro na lista de livros.
     *
     * @param li
     */
    public void addLivro(Livro li) {
        this.livros.add(li);
    }

    /**
     * getLivros retorna a lista de livros.
     *
     * @return
     */
    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    /**
     * removeLivro remove Livro da lista de livros.
     *
     * @param li
     */
    public void removeLivro(Livro li) {
        this.livros.remove(li);
    }

    /**
     * mockLivros inicializa aplicação com livros.
     */
    public void mockLivros() {
        Livro li1 = new Livro();
        li1.setIdLivro(this.geraID());
        li1.setTitulo("Pequeno Principe");
        li1.setAutor("Antoine de Saint-Exupéry");
        li1.setAssunto("Ludico");
        li1.setIsbn("789654123");
        li1.setEstoque(10);
        li1.setPreco((float)16.47);
        li1.setIdEditora(INF3M212LivrariaPOO.cadEditora.getEditoraCNPJ("456321789321"));
        this.addLivro(li1);
        Livro li2 = new Livro();
        li2.setIdLivro(this.geraID());
        li2.setTitulo("Harry Potter e a Pedra Filosofal");
        li2.setAutor("J. K. Rowling");
        li2.setAssunto("Ficção/Aventura");
        li2.setIsbn("82467319222");
        li2.setEstoque(20);
        li2.setPreco((float)33.99);
        li2.setIdEditora(INF3M212LivrariaPOO.cadEditora.getEditoraCNPJ("987987456321"));
        this.addLivro(li2);
    }

    /**
     * getLivroISBN pesquisa cliente pelo ISBN e retorna o Livro 
     * e caso não encontre retorna nulo podendo cadastrar.
     * @param isbn
     * @return
     */
    public Livro getLivroISBN(String isbn) {
        Livro li = null;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                li=  livro;
                break;
            }
        }
        return li;
    }
    
    public boolean atualizaEstoqueLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                if (livro.getEstoque()>0) {
                    livro.setEstoque(livro.getEstoque()-1);
                    return true;
                }
                break;
            }
        }
        return false;
    }

}//fim classe controller
