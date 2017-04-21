package br.ufpb.roteiro9;

import java.util.List;

/**
 *
 * @author gmnun
 */
public interface Agenda {

    public void cadastraPessoa(Pessoa p);
    public void apagaPessoa(String nomePessoa);
    public List<Pessoa> pesquisaAniversariantesDoDia(String dia);
    public Pessoa pesquisaPessoa(String nomePessoa);
    public List<Pessoa> getContatos();

}
