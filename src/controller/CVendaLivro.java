/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import inf3m212.livrariapoo.INF3M212LivrariaPOO;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Livro;
import model.VendaLivro;

/**
 *
 * @author jbferraz
 */
public class CVendaLivro {

    ArrayList<VendaLivro> vendaLivros = new ArrayList<>();
    int idVendaLivro = 1;

    /**
     * geraID gerencia a geração de id's autoincrement para VendaLivro.
     *
     * @return
     */
    public int geraID() {
        return this.idVendaLivro++;
    }

    /**
     * addVendaLivro adiciona um VendaLivro na lista de vendaLivros.
     *
     * @param vl
     */
    public void addVendaLivro(VendaLivro vl) {
        this.vendaLivros.add(vl);
    }

    /**
     * getVendaLivros retorna a lista de vendaLivros.
     *
     * @return
     */
    public ArrayList<VendaLivro> getVendaLivros() {
        return this.vendaLivros;
    }

    /**
     * removeVendaLivro remove VendaLivro da lista de vendaLivros.
     *
     * @param vl
     */
    public void removeVendaLivro(VendaLivro vl) {
        this.vendaLivros.remove(vl);
    }

    /**
     * mockVendaLivros inicializa aplicação com vendaLivros.
     */
    public void mockVendaLivros() {
        VendaLivro vl1 = new VendaLivro();
        vl1.setIdVendaLivro(this.geraID());
        vl1.setIdCliente(INF3M212LivrariaPOO.cadCliente.getClienteCPF("987654321"));
        vl1.setDataVenda(LocalDate.parse("2023-03-14"));
        ArrayList<Livro> livros1 = new ArrayList<>();
        livros1.add(INF3M212LivrariaPOO.cadLivro.getLivroISBN("82467319222"));
        livros1.add(INF3M212LivrariaPOO.cadLivro.getLivroISBN("789654123"));
        vl1.setLivros(livros1);
        vl1.setSubTotal((float) 50.00);
        this.addVendaLivro(vl1);
    }

}//fim classe controller
