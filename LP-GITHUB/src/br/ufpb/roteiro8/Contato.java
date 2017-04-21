package br.ufpb.roteiro8;

import br.ufpb.roteiro7.*;

/**
 *
 * @author gmnun
 */
public class Contato {

    private String nome, email;
    private Telefone telefone;
    private static int numContatosCriados = 0;
    private static final String NOME_DEFAULT = "Sem Nome";

    public Contato() {
        this.nome = NOME_DEFAULT;
        this.telefone = new Telefone();
        this.email = "";
    }

    public Contato(String nome, String email, Telefone telefone) {
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

    public int compareTo(Contato contato) {
        if (this.nome.compareTo(contato.nome) < 0) {
            return -1;
        } else if (this.nome.equals(contato.getNome())) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return ("Nome: " + this.getNome() + " Telefone: " + this.telefone.toString() + " E-mail: " + this.email);
    }

}
