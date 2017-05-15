package br.ufpb.roteiro7;

public class Agenda {

    private Contato[] contatos;
    private int numContatos;
    private static final int MAX_CONT = 100;
    
    public Agenda() {
        this.contatos = new Contato[MAX_CONT];
        this.numContatos = 0;
    }

    public void cadastrarContato(Contato c) {
        this.contatos[numContatos] = c;
        numContatos++;

    }

    public Contato[] getContatos() {
        return this.contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public void removerContato(String nome) {
        Contato[] nova = new Contato[MAX_CONT];
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (!this.contatos[i].getNome().equals(nome)) {
                nova[x] = this.contatos[i];
                x++;
            }
        }
        this.numContatos = x;
        this.contatos = nova;
    }

    public int getNumeroDeContatosCadastrados() {
        return this.numContatos;
    }

    public Telefone pesquisaTelefoneDoContato(String nome) {
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getNome().equals(nome)) {
                return this.contatos[i].getTelefone();
            }
        }
        return null;
    }

    public int getQuantidadeDeContatosDaOperadora(String operadora) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getOperadora().equals(operadora)) {
                x++;
            }
        }
        return x;
    }

    public int getQuantidadeDeContatosComPrefixo(String prefixo) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getPrefixo().equals(prefixo)) {
                x++;
            }
        }
        return x;
    }

    public String pesquisaNomeDeContatoPeloNumero(String prefixo, String numero) {
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getNumero().equals(numero) && this.contatos[i].getTelefone().getPrefixo().equals(prefixo)) {
                return this.contatos[i].getNome();
            }
        }
        return "Não há contatos com esse número.";
    }

    public Contato[] pesquisaContatosComeçandoComALetra(char letra) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getNome().charAt(0) == letra) {
                x++;
            }
        }
        Contato[] novaLista = new Contato[x];
        x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getNome().charAt(0) == letra) {
                novaLista[x] = this.contatos[i];
                x++;
            }
        }
        return novaLista;
    }

    public int getNumeroContatosComeçandoComALetra(char letra) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getNome().charAt(0) == letra) {
                x++;
            }
        }
        return x;
    }

    public Contato[] pesquisaContatosDaOperadora(String operadora) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getOperadora().equals(operadora)) {
                x++;
            }
        }
        Contato[] novaLista = new Contato[x];
        x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getOperadora().equals(operadora)) {
                novaLista[x] = this.contatos[i];
                x++;
            }
        }
        return novaLista;
    }

    public Contato[] pesquisaContatosComPrefixo(String prefixo) {
        int x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getPrefixo().equals(prefixo)) {
                x++;
            }
        }
        Contato[] novaLista = new Contato[x];
        x = 0;
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getTelefone().getPrefixo().equals(prefixo)) {
                novaLista[x] = this.contatos[i];
                x++;
            }
        }
        return novaLista;
    }

    public Telefone pesquisaContatoPeloNome(String nome) {
        for (int i = 0; i < this.numContatos; i++) {
            if (this.contatos[i].getNome().equals(nome)) {
                return this.contatos[i].getTelefone();
            }
        }
        return null;
    }
}
