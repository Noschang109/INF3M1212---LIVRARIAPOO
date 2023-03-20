/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jbferraz
 */
public class Editora {
    private int idEditora;
    private String nmEditora;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String gerente;

    public Editora() {
    }

    public Editora(int idEditora, String nmEditora, String cnpj, String endereco, String telefone, String gerente) {
        this.idEditora = idEditora;
        this.nmEditora = nmEditora;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.gerente = gerente;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNmEditora() {
        return nmEditora;
    }

    public void setNmEditora(String nmEditora) {
        this.nmEditora = nmEditora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Editora{" + "idEditora=" + idEditora + ", nmEditora=" + nmEditora + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone=" + telefone + ", gerente=" + gerente + '}';
    }
    
    
}
