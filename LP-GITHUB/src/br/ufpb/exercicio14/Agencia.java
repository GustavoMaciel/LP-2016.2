package br.ufpb.exercicio14;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class Agencia {
    private String numAgencia;
    private List<Contap> contas;

    public Agencia(String numero) {
        this.numAgencia = numero;
        this.contas = new LinkedList<>();
    }
    
    public String getNumAgencia() {
        return numAgencia;
    }
    public List<Contap> getContas() {
        return contas;
    }

    public void setContas(List<Contap> contas) {
        this.contas = contas;
    }
    public void setNumAgencia(String numAgencia) {
        this.numAgencia = numAgencia;
    }
    
    public void cadastrarConta(Contap x){
        this.contas.add(x);
    }
    
    public List<Contap> pesquisarSaldoNegativo(){
        List<Contap> neg = new LinkedList<>();
        this.contas.forEach((i) -> {
            if(i.getSaldoDisponível() < 0){
                neg.add(i);
            }
        });
        
        return neg;
    }
    
    public Contap pesquisarConta(String numConta){
        for(Contap i: this.contas){
            if(i.getNumero().equals(numConta)){
                return i;
            }
        }
        return null;
    }
    
    public List<Contap> pesquisarContasDoCliente(String cpf){
        List<Contap> con = new LinkedList<>();
        this.contas.forEach((i) -> {
            if(i.getCpfTitular().equals(cpf)){
                con.add(i);
            }
        });
        return con;
    }
    
    
    
}
