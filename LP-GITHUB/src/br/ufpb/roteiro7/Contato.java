package br.ufpb.roteiro7;

/**
 *
 * @author gmnun
 */
public class Contato {

    private String nome, email;
    private Telefone telefone;

    public Contato() {
        this.nome = null;
        this.telefone = null;
        this.email = null;
    }

    public Contato(String nome, String email, Telefone telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String getNome() {
        return this.nome;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
