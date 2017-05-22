package Roteiro10;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class SistemaCtrlE {

    public static void main(String[] args) throws Exception {
        GravadorDeParticipantes arq = new GravadorDeParticipantes();
        SistemaInscricoes ctrlE = new SistemaInscricoesList();

        boolean parar = false;
        while (!parar) {
            String opc = JOptionPane.showInputDialog("[~] Menu Ctrl+E\n\n[1] Menu Minicurso\n[2] Menu Participante\n[3] Carregar Dados\n[4] Salvar Dados\n[x] Sair");
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
                            try {
                                Minicurso x = ctrlE.pesquisarMinicurso(JOptionPane.showInputDialog("Título do Minicurso:"));
                                JOptionPane.showMessageDialog(null, "Título: " + x.getTitulo() + "\nNúmero máximo de Participantes: " + x.getMaxParticipantes() + "\nNúmero de Participantes: " + x.getParticipantes().size());
                                break;
                            } catch (MinicursoNaoExisteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;

                        case "x":
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    }
                    break;

                case "2":
                    String menuPart = JOptionPane.showInputDialog("[~] Menu Participantes\n\n[1] Adicionar Participante\n"
                            + "[2] Participantes do Estado\n[3] Participantes da Instituição\n[4] Pesquisar Participante\n[5] Listar Participantes\n[6] Remover Participante\n[x] Sair");
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
                                JOptionPane.showMessageDialog(null, i.getNome() + "\n" + i.getEmail());
                            });
                            break;

                        case "3":
                            ctrlE.pesquisaParticipantesDaInstituicao(JOptionPane.showInputDialog("Instituição: ")).forEach((i) -> {
                                JOptionPane.showMessageDialog(null, i.getNome() + "\n" + i.getEmail());
                            });
                            break;

                        case "4":
                            try {
                                JOptionPane.showMessageDialog(null, ctrlE.pesquisaParticipante(JOptionPane.showInputDialog("E-mail:")).toString());
                                break;
                            } catch (ParticipanteNaoExistenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                            break;

                        case "5":
                            List<Participante> abc = ctrlE.getParticipantes();
                            if (abc.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Não há participantes!");
                                break;
                            }
                            for (Participante i : abc) {
                                JOptionPane.showMessageDialog(null, "Nome: " + i.getNome() + "\nE-Mail: " + i.getEmail());
                            }
                            break;

                        case "6":
                            try {
                                String email = JOptionPane.showInputDialog("E-mail:");
                                String nome = ctrlE.pesquisaParticipante(email).getNome();
                                try {
                                    File remover = new File("src/Roteiro10/Part/" + nome + ".txt");
                                    remover.delete();
                                    ctrlE.removeParticipante(email);
                                } catch (Exception e) {
                                    ctrlE.removeParticipante(email);
                                }
                                JOptionPane.showMessageDialog(null, "Participante removido!");
                                break;
                            } catch (ParticipanteNaoExistenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;

                        case "x":
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                    break;

                case "3":
                    //Ler Participantes
                    try {
                        for (String i : arq.recuperaTextoDeArquivo("src/Roteiro10/Part/nomesParticipantes.txt")) {
                            String nameTxt = "src/Roteiro10/Part/" + i + ".txt";
                            List<String> info = arq.recuperaTextoDeArquivo(nameTxt);
                            ctrlE.addParticipante(new Participante(info.get(0), info.get(1), info.get(2), new Endereco(info.get(3), info.get(4),
                                    info.get(5), info.get(6))));
                        }
                    } catch (Exception e) {
                        continue;
                    }
                    //

                    // Ler Minicursos
                    try {
                        for (String i : arq.recuperaTextoDeArquivo("src/Roteiro10/Mini/titulosMinicursos.txt")) {
                            String titTxt = "src/Roteiro10/Mini/" + i + ".txt";
                            List<String> infoMi = arq.recuperaTextoDeArquivo(titTxt);
                            List<String> Emailpart = arq.recuperaTextoDeArquivo("src/Roteiro10/Mini/" + i + "Participantes.txt");
                            List<Participante> participantes = new LinkedList<>();
                            int j = 0;
                            for (String x : Emailpart) {
                                participantes.add(ctrlE.pesquisaParticipante(Emailpart.get(j)));
                                j++;
                            }
                            Minicurso a = new Minicurso(infoMi.get(0), Integer.parseInt(infoMi.get(1)));
                            a.setParticipantes(participantes);
                            try {
                                ctrlE.addMinicurso(a);
                            } catch (MinicursoJaExisteException e) {
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        continue;
                    }
                    //
                    JOptionPane.showMessageDialog(null, "Dados carregados com sucesso!");
                    break;

                case "4":
                    //Salvar participantes                    
                    for (Participante i : ctrlE.getParticipantes()) {
                        String nomeTxt = "src/Roteiro10/Part/";
                        try {
                            arq.gravaTextoEmArquivo(i.toStringArray(), nomeTxt + i.getNome() + ".txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        arq.gravaTextoEmArquivo(ctrlE.nomesToString(), "src/Roteiro10/Part/nomesParticipantes.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //Salvar minicursos
                    for (Minicurso i : ctrlE.getMinicursos()) {
                        String tituloTxt = "src/Roteiro10/Mini/";
                        try {
                            arq.gravaTextoEmArquivo(i.toStringArray(), tituloTxt + i.getTitulo() + ".txt");
                            arq.gravaTextoEmArquivo(i.ParticipantesToStringArray(), tituloTxt + i.getTitulo() + "Participantes.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        arq.gravaTextoEmArquivo(ctrlE.titulosToString(), "src/Roteiro10/Mini/titulosMinicursos.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                    break;
                case "x":
                    parar = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
