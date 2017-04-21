package br.ufpb.exercicio14;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class Banco {
    private int numero;
    private String nome;
    private List<Agencia> agencias;

    public Banco(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        agencias = new LinkedList<>();
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void cadastrarAgencia(Agencia i){
        this.agencias.add(i);
    }
    
    public Agencia pesquisarAgencia(String num){
        for(Agencia i: this.agencias){
            if(i.getNumAgencia().equals(num)){
                return i;
            }
        }
        return null;
    }
    
    
    
}
