package br.ufpb.roteiro8;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gmnun
 */
public class AgendaMenu {

    public static void main(String[] args) {
        AgendaList agenda = new AgendaList();
        boolean acabou = false;
        while (!acabou) {
            String opcao = JOptionPane.showInputDialog("Qual a opção desejada?\n[1] Cadastrar contato\n[2] Pesquisar\n[3] Remover contato\n[4] Sair ");
            switch (opcao) {
                case "1":
                    String nome = JOptionPane.showInputDialog("Qual o nome do contato?");
                    String email = JOptionPane.showInputDialog("Qual o email do contato?");
                    Contato c = new Contato();
                    c.setNome(nome);
                    c.setEmail(email);
                    String prefixo = JOptionPane.showInputDialog("Qual o prefixo?");
                    String numero = JOptionPane.showInputDialog("Qual o número?");
                    String operadora = JOptionPane.showInputDialog("Qual a operadora?");
                    Telefone tel = new Telefone(prefixo, numero, operadora);
                    c.setTelefone(tel);
                    agenda.cadastrarContato(c);
                    break;
                case "2":
                    String conca = "";
                    ArrayList<Contato> listaEncontrada = new ArrayList<>();
                    String opcao2 = JOptionPane.showInputDialog("Pesquisar por: " + "\n[1] Pesquisar telefone pelo nome" + "\n[2] Pesquisar contatos que começam com uma letra" + "\n[3] Pesquisar contatos pelo número");
                    switch (opcao2) {
                        case "1":
                            String nomeContato = JOptionPane.showInputDialog("Qual o nome do contato a pesquisar?");
                            Telefone telEncontrado = agenda.pesquisaContatoPeloNome(nomeContato);
                            if (telEncontrado != null) {
                                JOptionPane.showMessageDialog(null, "O telefone de " + nomeContato + " é: " + telEncontrado.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado telefone para: " + nomeContato);
                            }
                            break;

                        case "2":
                            char letra = JOptionPane.showInputDialog("Digite a letra desejada: ").charAt(0);
                            listaEncontrada = agenda.pesquisaContatosComeçandoComALetra(letra);
                            for (Contato i : listaEncontrada) {
                                conca += i.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, conca);
                            break;
                            
                        case "3":
                            String prefix = JOptionPane.showInputDialog("Prefixo: ");
                            String nomero = JOptionPane.showInputDialog("Número: ");
                            listaEncontrada = agenda.pesquisaContatoPeloNumero(prefix, nomero);
                            for (Contato i : listaEncontrada) {
                                conca += i.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, conca);
                            break;
                            
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                    break;
                case "3":
                    String nomeDoContatoARemover = JOptionPane.showInputDialog("Qual o nome do contato a remover?");
                    int numeroContatosAntes = agenda.getNumeroDeContatosCadastrados();
                    agenda.removerContato(nomeDoContatoARemover);
                    int numContatosDepois = agenda.getNumeroDeContatosCadastrados();
                    if (numContatosDepois < numeroContatosAntes) {
                        JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");

                    } else {
                        JOptionPane.showMessageDialog(null, "Contato não removido!");
                    }
                    break;
                case "4":
                    acabou = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }
    }

}
