package br.ufpb.roteiro9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class AgendaList implements Agenda{
    private List<Pessoa> contatos;

    public AgendaList() {
    this.contatos = new ArrayList<>();
    }

    public AgendaList(List<Pessoa> contatos) {
        this.contatos = contatos;
    }
    
    @Override
    public List<Pessoa> getContatos(){
        return this.contatos;
    }

    @Override
    public void apagaPessoa(String nomePessoa) {
        for(Pessoa i: this.contatos){
            if(i.getNome().equalsIgnoreCase(nomePessoa)){
                this.contatos.remove(i);
                break;
            }
        }
    }

    @Override
    public void cadastraPessoa(Pessoa p) {
        this.contatos.add(p);
    }

    @Override
    public List<Pessoa> pesquisaAniversariantesDoDia(String dia) {
        List<Pessoa> aniversariantes = new ArrayList<>();
        for(Pessoa i: this.contatos){
            if(i.getDataAniversario().startsWith(dia)){
                aniversariantes.add(i);
            }
        }
        return aniversariantes;
    }

    @Override
    public Pessoa pesquisaPessoa(String nomePessoa) {
        for(Pessoa i: this.contatos){
            if(i.getNome().equalsIgnoreCase(nomePessoa)){
                return i;
            }
        }
        return null;
    }
}
