package Roteiro10;

/**
 *
 * @author gmnun
 */
public class Participante {
    private String nome, email, instituicao;
    private Endereco endereco;

    public Participante() {
        nome = "";
        email = "";
        instituicao = "";
        endereco = new Endereco();
    }

    public Participante(String nome, String email, String instituicao, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.instituicao = instituicao;
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public String getInstituicao() {
        return instituicao;
    }
    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "; E-mail: " + email + "; Instituição: " + instituicao + "; Endereço: " + endereco;
    }
    
    
}
