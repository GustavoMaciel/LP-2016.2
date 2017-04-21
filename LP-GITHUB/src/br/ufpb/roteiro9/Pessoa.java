package br.ufpb.roteiro9;

/**
 *
 * @author gmnun
 */
public class Pessoa {
    private String nome;
    private String telefone;
    private String dataAniversario;
    private static final String STRING_PADRAO = "No Value";
    
    public Pessoa() {
        nome = STRING_PADRAO;
        telefone = STRING_PADRAO;
        dataAniversario = STRING_PADRAO;
    }

    public Pessoa(String nome, String telefone, String dataAniversario) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataAniversario = dataAniversario;
    }
    
    public Pessoa(String nome){
        this.nome = nome;
        telefone = STRING_PADRAO;
        dataAniversario = STRING_PADRAO;
    }

    public Pessoa(String nome, String dataAniversario){
        this.nome = nome;
        this.dataAniversario = dataAniversario;
        telefone = STRING_PADRAO;
    }
    
    public String getDataAniversario() {
        return dataAniversario;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Data: " + dataAniversario + " Telefone: " + telefone;
    }
    
    
    
}
