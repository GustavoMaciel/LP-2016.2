package br.ufpb.roteiro8;

import java.util.ArrayList;

/**
 *
 * @author gmnun
 */
public class AgendaList {

    private ArrayList<Contato> contatos;

    public AgendaList() {
        this.contatos = new ArrayList<>();
    }

    public void cadastrarContato(Contato c) {
        this.contatos.add(c);

    }

    public ArrayList<Contato> getContatos() {
        return this.contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public void removerContato(String nome) {
        for (Contato i : contatos) {
            if(i.getNome().equalsIgnoreCase(nome)){
                this.contatos.remove(i);
                break;
            }
        }
    }

    public int getNumeroDeContatosCadastrados() {
        return this.contatos.size();
    }

    public Telefone pesquisaTelefoneDoContato(String nome) {
        for (Contato i: contatos){
            if(i.getNome().equalsIgnoreCase(nome)){
                return i.getTelefone();
            }
        }
        return null;
    }

    public int getQuantidadeDeContatosDaOperadora(String operadora) {
        int x = 0;
        for(Contato i: contatos) {
            if (i.getTelefone().getOperadora().equals(operadora)) {
                x++;
            }
        }
        return x;
    }

    public int getQuantidadeDeContatosComPrefixo(String prefixo) {
        int x = 0;
        for (Contato i: contatos) {
            if (i.getTelefone().getPrefixo().equals(prefixo)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Contato> pesquisaContatoPeloNumero(String prefixo, String numero){
        ArrayList<Contato> nova = new ArrayList<>();
        for (Contato i: contatos) {
            if (i.getTelefone().getNumero().equals(numero) && i.getTelefone().getPrefixo().equals(prefixo)) {
                nova.add(i);
            }
        }
        return nova;
    }
    public String pesquisaNomeDeContatoPeloNumero(String prefixo, String numero) {
        for (Contato i: contatos) {
            if (i.getTelefone().getNumero().equals(numero) && i.getTelefone().getPrefixo().equals(prefixo)) {
                return i.getNome();
            }
        }
        return "Não há contatos com esse número.";
    }

    public ArrayList<Contato> pesquisaContatosComeçandoComALetra(char letra) {
        ArrayList<Contato> nova = new ArrayList<>();
        for (Contato i: contatos) {
            if (i.getNome().charAt(0) == letra) {
                nova.add(i);
            }
        }
        return nova;
    }

    public int getNumeroContatosComeçandoComALetra(char letra) {
        int x = 0;
        for (Contato i: contatos) {
            if (i.getNome().charAt(0) == letra) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Contato> pesquisaContatosDaOperadora(String operadora) {
        ArrayList<Contato> nova = new ArrayList<Contato>();
        for (Contato i: contatos) {
            if (i.getTelefone().getOperadora().equalsIgnoreCase(operadora)) {
                nova.add(i);
            }
        }
        return nova;
    }

    public ArrayList<Contato> pesquisaContatosComPrefixo(String prefixo) {
        ArrayList<Contato> nova = new ArrayList<Contato>();
        for (Contato i: contatos) {
            if (i.getTelefone().getPrefixo().equals(prefixo)) {
                nova.add(i);
            }
        }
        return nova;
    }

    public Telefone pesquisaContatoPeloNome(String nome) {
        for (Contato i: contatos) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                return i.getTelefone();
            }
        }
        return null;
    }
    
    public ArrayList<Contato> pesquisaContatosIniciadosCom(String inicio){
        ArrayList<Contato> nova = new ArrayList<>();
        for(Contato i: contatos){
            if(i.getNome().startsWith(inicio)){
                nova.add(i);
            }
        }
        return nova;
    }
    
    public ArrayList<Contato> pesquisaContatosComEmailTerminadoEm(String termino){
        ArrayList<Contato> nova = new ArrayList<>();
        for(Contato i: contatos){
            if(i.getEmail().endsWith(termino)){
                nova.add(i);
            }
        }
        return nova;
    }

}
