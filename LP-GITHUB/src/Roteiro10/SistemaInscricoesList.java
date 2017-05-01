package Roteiro10;

import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author gmnun
 */
public class SistemaInscricoesList implements SistemaInscricoes{

    private List<Participante> participantes;
    private List<Minicurso> minicursos;

    public SistemaInscricoesList() {
        this.participantes = new LinkedList<>();
        this.minicursos = new LinkedList<>();
    }

    @Override
    public List<Minicurso> getMinicursos() {
        return minicursos;
    }
    @Override
    public List<Participante> getParticipantes() {
        return participantes;
    }
    
    @Override
    public void removeParticipante(String email) {
        for(Participante i: this.participantes){
            if(i.getEmail().equals(email)){
                this.participantes.remove(i);
                break;
            }
        }
    }
    @Override
    public void addParticipante(Participante i) {
        this.participantes.add(i);
    }
    @Override
    public void inscreveParticipanteEmMinicurso(String emailPart, String tituloMinicurso) {
        Participante x = null;
        for(Participante i: this.participantes){
            if(i.getEmail().equals(emailPart)){
                x = i;
            }
        }
        if(x != null){
            for(Minicurso i: this.minicursos){
                if(i.getTitulo().equals(tituloMinicurso)){
                    i.addParticipante(x);
                }
            }
        }
    }

    @Override
    public Participante pesquisaParticipante(String email) {
        for(Participante i: this.participantes){
            if(i.getEmail().equals(email)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Participante> pesquisaParticipantesDaInstituicao(String instituicao) {
        List<Participante> x = new LinkedList<>();
        for(Participante i: this.participantes){
            if(i.getInstituicao().equals(instituicao)){
                x.add(i);
            }
        }
        return x;
    }

    @Override
    public List<Participante> pesquisaParticipantesDoEstado(String estado) {
        List<Participante> x = new LinkedList<>();
        for(Participante i: this.participantes){
            if(i.getEndereco().getEstado().equals(estado)){
                x.add(i);
            }
        }
        return x;
    }
    
    @Override
    public void addMinicurso(Minicurso i){
        this.minicursos.add(i);
    }
    
    @Override
    public Minicurso pesquisarMinicurso(String titulo){
        for(Minicurso i: this.minicursos){
            if(i.getTitulo().equalsIgnoreCase(titulo)){
                return i;
            }
        }
        return null;
    }
    
}
