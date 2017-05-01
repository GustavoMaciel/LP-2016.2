package Roteiro10;
import javax.swing.JOptionPane;

/**
 *
 * @author gmnun
 */
public class SistemaCtrlE {
    public static void main(String[] args) {
        SistemaInscricoes ctrlE = new SistemaInscricoesList();
        boolean parar = false;
        while(!parar){
            String opc = JOptionPane.showInputDialog("[~] Menu Ctrl+E\n\n[1] Menu Minicurso\n[2] Menu Participante\n[x] Sair");
            switch(opc){
                case "1":
                    String menuMini = JOptionPane.showInputDialog("[~] Menu Minicurso\n\n[1] Adicionar Minicurso\n"
                            + "[2] Cadastrar Participante em Minicurso\n[3] Info de Minicurso\n[x] Sair");
                    switch(menuMini){
                        case "1":
                            ctrlE.addMinicurso(new Minicurso(JOptionPane.showInputDialog("Título do Minicurso:"), Integer.parseInt(JOptionPane.showInputDialog("Número máximo de participantes:"))));
                            break;
                        
                        case "2":
                            ctrlE.inscreveParticipanteEmMinicurso(JOptionPane.showInputDialog("E-mail do participante:"), JOptionPane.showInputDialog("Título do Minicurso:"));
                            break;
                        
                        case "3":
                            Minicurso x = ctrlE.pesquisarMinicurso(JOptionPane.showInputDialog("Título do Minicurso:"));
                            JOptionPane.showMessageDialog(null, "Título: " + x.getTitulo() + "\nNúmero de Participantes: " + x.getParticipantes().size());
                            break;
                    }
                    break;
                
                case "2":
                    String menuPart = JOptionPane.showInputDialog("[~] Menu Participantes\n\n[1] Adicionar Participante\n"
                            + "[2] Participantes do Estado\n[3] Participantes da Instituição\n[4] Pesquisar Participante\n[5] Remover Participante\n[x] Sair");
                    switch(menuPart){
                        case "1":
                            ctrlE.addParticipante(new Participante(JOptionPane.showInputDialog("Nome: "), 
                                    JOptionPane.showInputDialog("E-Mail: "), 
                                    JOptionPane.showInputDialog("Instituição: "), 
                                    new Endereco(JOptionPane.showInputDialog("Logradouro: "), JOptionPane.showInputDialog("Cidade: "),
                                            JOptionPane.showInputDialog("Estado: "), Integer.parseInt(JOptionPane.showInputDialog("Número: ")))));
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
                            JOptionPane.showMessageDialog(null, ctrlE.pesquisaParticipante(JOptionPane.showInputDialog("E-mail:")));
                            break;
                            
                        case "5":
                            ctrlE.removeParticipante(JOptionPane.showInputDialog("E-mail:"));
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
