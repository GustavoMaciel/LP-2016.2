package br.ufpb.roteiro9;

import javax.swing.JOptionPane;

/**
 *
 * @author gmnun
 */
public class TestaAgendaList {
    public static void main(String[] args) {
        Agenda agenda = new AgendaList();
        agenda.cadastraPessoa(new Pessoa(JOptionPane.showInputDialog("Nome: "), JOptionPane.showInputDialog("Aniversário: ")));
        
        agenda.pesquisaAniversariantesDoDia("29/12").forEach((i) -> {
            JOptionPane.showMessageDialog(null, i);
        });
        
        Pessoa x = agenda.pesquisaPessoa(JOptionPane.showInputDialog("Pessoa à pesquisar:"));
        if(x == null){
            JOptionPane.showMessageDialog(null, "Contato não encontrado");
        }else {
            JOptionPane.showMessageDialog(null, x);
        }
        
    }
}
