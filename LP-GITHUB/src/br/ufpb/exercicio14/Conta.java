package br.ufpb.exercicio14;

/**
 *
 * @author gmnun
 */
public abstract class Conta {
    private String numConta;
    private static int numero = 0;
    private double saldo;
    private String cpf;
    
    public Conta(){
        numero++;
        this.numConta = String.valueOf(numero);
        this.saldo = 0;
        this.cpf = "";
    }
    
    public Conta(double saldo, String cpf, String numConta){
        this.saldo = saldo;
        this.cpf = cpf;
        this.numConta = numConta;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setNumConta(String numConta){
        this.numConta = numConta;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return cpf;
    }
    public String getNumConta(){
        return numConta;
    }
    public double getSaldo(){
        return saldo;
    }
    
    public double sacar(double valor){
        if(this.getSaldoDisponivel() >= valor){
            this.saldo -= valor;
        }
        return this.saldo;
    }
    
    public double depositar(double valor){
        this.saldo += valor;
        return this.saldo;
    }
    
    public abstract double getSaldoDisponivel();
}
