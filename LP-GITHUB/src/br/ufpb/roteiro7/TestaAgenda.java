package br.ufpb.roteiro7;

public class TestaAgenda {

    public static void main(String[] args) {

        Telefone o = new Telefone("69", "9301235869", "Claro");
        Telefone u = new Telefone("69", "9801235869", "Tim");
        Contato a = new Contato("Gus", "guasd", o);
        Contato b = new Contato("Jas", "aspdoi", new Telefone("83", "8401293039", "Oi"));
        Contato c = new Contato("Das", "pasidposi", u);

        Agenda x = new Agenda();
        x.cadastrarContato(a);
        x.cadastrarContato(b);
        x.cadastrarContato(c);
        x.cadastrarContato(c);
        x.cadastrarContato(a);
        x.removerContato("a");

        for(int i = 0; i < x.getNumeroDeContatosCadastrados(); i++){
            System.out.println(x.getContatos()[i].getNome());
        }
    }
}
