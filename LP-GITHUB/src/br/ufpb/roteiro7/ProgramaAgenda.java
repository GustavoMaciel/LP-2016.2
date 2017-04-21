package br.ufpb.roteiro7;

import javax.swing.JOptionPane;

public class ProgramaAgenda {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int num = Integer.parseInt(JOptionPane.showInputDialog("Quantos contatos deseja criar?"));
        for (int i = 0; i < num; i++) {
            String nome = JOptionPane.showInputDialog("Nome :");
            String email = JOptionPane.showInputDialog("E-mail: ");
            String numero = JOptionPane.showInputDialog("Numero :");
            String operadora = JOptionPane.showInputDialog("Operadora:");
            String pref = JOptionPane.showInputDialog("Prefixo: ");
            Telefone o = new Telefone(pref, numero, operadora);
            Contato x = new Contato(nome, email, o);
            agenda.cadastrarContato(x);
        }

        Contato[] a = agenda.getContatos();
        for (Contato i : a) {
            if (i != null) {
                JOptionPane.showMessageDialog(null, "Nome: " + i.getNome() + "\nNúmero: " + i.getTelefone().getNumero());
            } else {
                break;
            }
        }

        String ope = JOptionPane.showInputDialog("Digite a operadora que deseja pesquisar");
        JOptionPane.showMessageDialog(null, "Há " + agenda.getQuantidadeDeContatosDaOperadora(ope)
                + " contatos cadastrados com essa operadora. Que são:");
        for (int i = 0; i < agenda.getNumeroDeContatosCadastrados(); i++) {
            if (agenda.getContatos()[i].getTelefone().getOperadora().equals(ope)) {
                JOptionPane.showMessageDialog(null, agenda.getContatos()[i].getNome());
            }
        }

        char let = JOptionPane.showInputDialog("Digite uma letra: ").charAt(0);
        a = agenda.pesquisaContatosComeçandoComALetra(let);
        JOptionPane.showMessageDialog(null, "Há " + agenda.getNumeroContatosComeçandoComALetra(let)
                + " contatos cadastrados começando com essa letra. Que são: ");
        for (Contato i : a) {
            JOptionPane.showMessageDialog(null, i.getNome());
        }

        String pre = JOptionPane.showInputDialog("Digite um prefixo: ");
        a = agenda.pesquisaContatosComPrefixo(pre);
        JOptionPane.showMessageDialog(null, "Há " + agenda.getQuantidadeDeContatosComPrefixo(pre) + " contatos cadastrados com esse prefixo. Que são: ");
        for (Contato i : a) {
            JOptionPane.showMessageDialog(null, i.getNome() + " (" + i.getTelefone().getPrefixo() + ") " + i.getTelefone().getNumero());
        }

        String name = JOptionPane.showInputDialog("Digite um nome:");
        JOptionPane.showMessageDialog(null, agenda.pesquisaContatoPeloNome(name).getFullInfo());

    }

}
