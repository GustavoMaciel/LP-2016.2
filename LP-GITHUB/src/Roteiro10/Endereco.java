package Roteiro10;

/**
 *
 * @author gmnun
 */
public class Endereco {
    private String logradouro, cidade, estado, numero;

    public Endereco(){
        this("","","","");
    }

    public Endereco(String logradouro, String cidade, String estado, String numero) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getNumero() {
        return numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Logradouro: " + logradouro + "; Número: " + numero + "; Cidade: " + cidade + "; Estado: " + estado;
    }
    
    
    
}
