package br.ufpb.exercicio14;

/**
 *
 * @author gmnun
 */
public class ContaEspecial extends Contap{
   private double credito;

    public ContaEspecial(double credito) {
        super();
        this.credito = credito;
    }

    public ContaEspecial(double credito, String numero, double saldo, String cpfTitular) {
        super(numero, saldo, cpfTitular);
        this.credito = credito;
    }

    public ContaEspecial() {
        super();
        credito = 1000d;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public double getSaldoDisponível() {
        return super.getSaldo() + this.credito;
    }
    
}
