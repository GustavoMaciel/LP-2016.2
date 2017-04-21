package br.ufpb.exercicio14;

/**
 *
 * @author gmnun
 */
public class ContaSimples extends Contap{

    public ContaSimples() {
        super();
    }
    
    public ContaSimples(String numero, double saldo, String cpf) {
        super(numero, saldo, cpf);
    }
    
    @Override
    public double getSaldoDisponível() {
        return super.getSaldo();
    }
    
}
