package Roteiro10;

import javax.swing.JOptionPane;
import arquivos.Gravador;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class SistemaCtrlE {

    public static void main(String[] args) throws Exception {
        Gravador arq = new Gravador();
        SistemaInscricoes ctrlE = new SistemaInscricoesList();
        
        //Ler Participantes
        try{
        for(String i: arq.recuperaTextoDeArquivo("src/Roteiro10/Part/nomesParticipantes.txt")){
            String nameTxt = "src/Roteiro10/Part/" + i + ".txt";
            List<String> info = arq.recuperaTextoDeArquivo(nameTxt);
            ctrlE.addParticipante(new Participante(info.get(0), info.get(1), info.get(2), new Endereco(info.get(3), info.get(4),
            info.get(5), info.get(6))));
        }}catch(Exception e){
            System.out.println("Tamo carregando parça");
        }       
        //
        
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
                            try {
                                Minicurso x = ctrlE.pesquisarMinicurso(JOptionPane.showInputDialog("Título do Minicurso:"));
                                JOptionPane.showMessageDialog(null, "Título: " + x.getTitulo() + "\nNúmero de Participantes: " + x.getParticipantes().size());
                                break;
                            } catch (MinicursoNaoExisteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
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
                            try {
                                JOptionPane.showMessageDialog(null, ctrlE.pesquisaParticipante(JOptionPane.showInputDialog("E-mail:")).toString());
                                break;
                            } catch (ParticipanteNaoExistenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                            break;

                        case "5":
                            try {
                                ctrlE.removeParticipante(JOptionPane.showInputDialog("E-mail:"));
                                break;
                            } catch (ParticipanteNaoExistenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                            break;
                    }
                    break;

                case "x":

                    parar = true;

                    //Salvar participantes
                    
                    for (Participante i : ctrlE.getParticipantes()) {
                        String nomeTxt = "src/Roteiro10/Part/";
                        try {
                            arq.gravaTextoEmArquivo(i.toStringArray(), nomeTxt + i.getNome() + ".txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    
                    try{
                        arq.gravaTextoEmArquivo(ctrlE.nomesToString(), "src/Roteiro10/Part/nomesParticipantes.txt");
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                    break;

                default:
                    break;
            }
        }
    }
}
