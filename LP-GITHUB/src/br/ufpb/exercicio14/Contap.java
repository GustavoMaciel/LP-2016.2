package br.ufpb.exercicio14;

/**
 *
 * @author gmnun
 */
public abstract class Contap {
    private String numero;
    private double saldo;
    private String cpfTitular;
    private static final String PATTERN = "No Value";

    public Contap() {
        numero = PATTERN;
        cpfTitular = PATTERN;
        saldo = 0.0;
    }

    public Contap(String numero, double saldo, String cpfTitular) {
        this.numero = numero;
        this.saldo = saldo;
        this.cpfTitular = cpfTitular;
    }

    public double getSaldo() {
        return saldo;
    }
    public String getCpfTitular() {
        return cpfTitular;
    }
    public String getNumero() {
        return numero;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double sacar(double valor){
        if(this.getSaldoDisponível() >= valor){
            this.saldo -= valor;
        }else{
            return 0;
        }
        return this.saldo;
    }
    
    public double depositar(double valor){
        this.saldo += valor;
        return this.saldo;
    }
    
    public  abstract double getSaldoDisponível();
    
}
