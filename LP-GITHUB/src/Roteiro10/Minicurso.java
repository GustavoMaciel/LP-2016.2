package Roteiro10;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author gmnun
 */
public class Minicurso {
    private List<Participante> participantes;
    private int maxParticipantes;
    private String tituloMinicurso;
    
    public Minicurso(String titulo, int max){
        this.tituloMinicurso = titulo;
        this.participantes = new LinkedList<>();
        this.maxParticipantes = max;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    
    public List<Participante> getParticipantes() {
        return participantes;
    }
    public int getMaxParticipantes() {
        return maxParticipantes;
    }
    public String getTitulo() {
        return tituloMinicurso;
    }
    
    public void addParticipante(Participante i) throws Exception{
        if(this.participantes.size() < this.maxParticipantes){
            for(Participante x: this.participantes){
                if(i.getEmail().equals(x.getEmail())){
                    throw new ParticipanteJaExistenteException("Já existe um participante com o e-mail: " + i.getEmail());
                }
            }
            this.participantes.add(i);
        }
    }
    public List<String> ParticipantesToStringArray(){
        List<String> a = new LinkedList<>();
        this.participantes.forEach((i) -> {
            a.add(i.getEmail());
        });
        return a;
    }
    public List<String> toStringArray(){
        List<String> a = new LinkedList<>();
        a.add(tituloMinicurso);
        a.add(String.valueOf(maxParticipantes));
        return a;
    }
}
