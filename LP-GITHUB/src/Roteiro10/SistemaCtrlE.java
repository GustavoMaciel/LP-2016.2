package Roteiro10;

import javax.swing.JOptionPane;

/**
 *
 * @author gmnun
 */
public class SistemaCtrlE {

    public static void main(String[] args) throws Exception {
        SistemaInscricoes ctrlE = new SistemaInscricoesList();
        boolean parar = false;
        while (!parar) {
            String opc = JOptionPane.showInputDialog("[~] Menu Ctrl+E\n\n[1] Menu Minicurso\n[2] Menu Participante\n[x] Sair");
            switch (opc) {
                case "1":
                    String menuMini = JOptionPane.showInputDialog("[~] Menu Minicurso\n\n[1] Adicionar Minicurso\n"
                            + "[2] Cadastrar Participante em Minicurso\n[3] Info de Minicurso\n[x] Sair");
                    switch (menuMini) {
                        case "1":
                            while (true) {
                                try {
                                    ctrlE.addMinicurso(new Minicurso(JOptionPane.showInputDialog("Título do Minicurso:"), Integer.parseInt(JOptionPane.showInputDialog("Número máximo de participantes:"))));
                                    break;
                                } catch (MinicursoJaExisteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Você é burro é cara? mandando letra pra um número!");
                                }
                            }
                            break;

                        case "2":
                                try {
                                    ctrlE.inscreveParticipanteEmMinicurso(JOptionPane.showInputDialog("E-mail do participante:"), JOptionPane.showInputDialog("Título do Minicurso:"));
                                    
                                } catch (ParticipanteJaExistenteException | ParticipanteNaoExistenteException | MinicursoNaoExisteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            break;

                        case "3":
                            while (true) {
                                try {
                                    Minicurso x = ctrlE.pesquisarMinicurso(JOptionPane.showInputDialog("Título do Minicurso:"));
                                    JOptionPane.showMessageDialog(null, "Título: " + x.getTitulo() + "\nNúmero de Participantes: " + x.getParticipantes().size());
                                    break;
                                } catch (MinicursoNaoExisteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            break;
                    }
                    break;

                case "2":
                    String menuPart = JOptionPane.showInputDialog("[~] Menu Participantes\n\n[1] Adicionar Participante\n"
                            + "[2] Participantes do Estado\n[3] Participantes da Instituição\n[4] Pesquisar Participante\n[5] Remover Participante\n[x] Sair");
                    switch (menuPart) {
                        case "1":
                            while (true) {
                                try {
                                    ctrlE.addParticipante(new Participante(JOptionPane.showInputDialog("Nome: "),
                                            JOptionPane.showInputDialog("E-Mail: "),
                                            JOptionPane.showInputDialog("Instituição: "),
                                            new Endereco(JOptionPane.showInputDialog("Logradouro: "), JOptionPane.showInputDialog("Cidade: "),
                                                    JOptionPane.showInputDialog("Estado: "), JOptionPane.showInputDialog("Número: "))));
                                    break;
                                } catch (ParticipanteJaExistenteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            break;

                        case "2":
                            ctrlE.pesquisaParticipantesDoEstado(JOptionPane.showInputDialog("Estado: ")).forEach((i) -> {
                                JOptionPane.showMessageDialog(null, i.getNome());
                            });
                            break;

                        case "3":
                            ctrlE.pesquisaParticipantesDaInstituicao(JOptionPane.showInputDialog("Instituição: ")).forEach((i) -> {
                                JOptionPane.showMessageDialog(null, i.getNome());
                            });
                            break;

                        case "4":
                            while (true) {
                                try {
                                    JOptionPane.showMessageDialog(null, ctrlE.pesquisaParticipante(JOptionPane.showInputDialog("E-mail:")).toString());
                                    break;
                                } catch (ParticipanteNaoExistenteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            break;

                        case "5":
                            while (true) {
                                try {
                                    ctrlE.removeParticipante(JOptionPane.showInputDialog("E-mail:"));
                                    break;
                                } catch (ParticipanteNaoExistenteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            break;
                    }
                    break;

                case "x":
                    parar = true;
                    break;

                default:
                    break;
            }
        }
    }
}
