package Roteiro10;
import java.util.List;
/**
 *
 * @author gmnun
 */
public interface SistemaInscricoes {
    public void addParticipante(Participante i);
    public void removeParticipante(String i);
    public List<Participante> pesquisaParticipantesDaInstituicao(String instituicao);
    public List<Participante> pesquisaParticipantesDoEstado(String estado);
    public Participante pesquisaParticipante(String email);
    public void inscreveParticipanteEmMinicurso(String emailPart, String tituloMinicurso);
    public void addMinicurso(Minicurso i);
    public Minicurso pesquisarMinicurso(String titulo);
    public List<Minicurso> getMinicursos();
    public List<Participante> getParticipantes();
}
