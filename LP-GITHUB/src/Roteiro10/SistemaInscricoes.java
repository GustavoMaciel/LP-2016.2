package Roteiro10;
import java.util.List;
/**
 *
 * @author gmnun
 */
public interface SistemaInscricoes {
    public void addParticipante(Participante i) throws Exception;
    public void removeParticipante(String i) throws Exception;
    public List<Participante> pesquisaParticipantesDaInstituicao(String instituicao);
    public List<Participante> pesquisaParticipantesDoEstado(String estado);
    public Participante pesquisaParticipante(String email) throws Exception;
    public void inscreveParticipanteEmMinicurso(String emailPart, String tituloMinicurso) throws Exception;
    public void addMinicurso(Minicurso i)  throws MinicursoJaExisteException;
    public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException;
    public Minicurso pesquisarMinicurso(String titulo) throws MinicursoNaoExisteException;
    public List<Minicurso> getMinicursos();
    public List<Participante> getParticipantes();
    public List<String> nomesToString() throws Exception;
    public List<String> titulosToString() throws Exception;
}
