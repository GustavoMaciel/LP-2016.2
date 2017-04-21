package br.ufpb.roteiro7;

/**
 *
 * @author gmnun
 */
public class Telefone {
    private String numero;
    private String operadora;
    private String prefixo;
    
    public Telefone(){
        this.numero = null;
        this.operadora = null;
        this.prefixo = null;
    }
    public Telefone(String prefixo, String numero, String operadora){
        this.numero = numero;
        this.prefixo = prefixo;
        this.operadora = operadora;
}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    
    public String getFullInfo(){
        return this.operadora + " (" + this.prefixo + ") " + this.numero;
    }
}
    
    
