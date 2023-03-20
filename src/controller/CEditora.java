/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author jbferraz
 */
public class CEditora {

    ArrayList<Editora> editoras = new ArrayList<>();
    int idEditora = 1;

    /**
     * geraID gerencia a geração de id's autoincrement para Editora.
     *
     * @return
     */
    public int geraID() {
        return this.idEditora++;
    }

    /**
     * addEditora adiciona uma editora na lista de editoras.
     *
     * @param e
     */
    public void addEditora(Editora e) {
        this.editoras.add(e);
    }

    /**
     * getEditoras retorna a lista de editoras.
     *
     * @return
     */
    public ArrayList<Editora> getEditoras() {
        return this.editoras;
    }

    /**
     * removeEditora remove Editora da lista de editoras.
     *
     * @param e
     */
    public void removeEditora(Editora e) {
        this.editoras.remove(e);
    }

    /**
     * mockEditoras inicializa aplicação com editoras.
     */
    public void mockEditoras() {
        Editora e1 = new Editora();
        e1.setIdEditora(this.geraID());
        e1.setNmEditora("Abril");
        e1.setCnpj("987987456321");
        e1.setEndereco("Rua das Oliveiras");
        e1.setTelefone("51888999888");
        e1.setGerente("Juventino");
        this.addEditora(e1);
        Editora e2 = new Editora();
        e2.setIdEditora(this.geraID());
        e2.setNmEditora("Senac");
        e2.setCnpj("456321789321");
        e2.setEndereco("Rua das Flores");
        e2.setTelefone("51999998888");
        e2.setGerente("Adroaldo");
        this.addEditora(e2);
    }

    /**
     * getEditoraCNPJ pesquisa editora pelo CNPJ e retorna a editora 
     * e caso não encontre retorna nulo podendo cadastrar.
     * @param cnpj
     * @return
     */
    public Editora getEditoraCNPJ(String cnpj) {
        Editora e = null;
        for (Editora editora : editoras) {
            if (editora.getCnpj().equals(cnpj)) {
                e = editora;
                break;
            }
        }

        return e;
    }

}//fim classe controller
