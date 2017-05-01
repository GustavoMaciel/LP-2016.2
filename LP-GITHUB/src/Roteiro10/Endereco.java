package Roteiro10;

/**
 *
 * @author gmnun
 */
public class Endereco {
    private String logradouro, cidade, estado;
    private int numero;

    public Endereco(){
        logradouro = "";
        cidade = "";
        estado = "";
        numero = 0;
    }

    public Endereco(String logradouro, String cidade, String estado, int numero) {
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
    public int getNumero() {
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
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Logradouro: " + logradouro + "; Número: " + numero + "; Cidade: " + cidade + "; Estado: " + estado;
    }
    
    
    
}
