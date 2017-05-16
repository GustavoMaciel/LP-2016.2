package Roteiro10;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author gmnun
 */
public class SistemaInscricoesList implements SistemaInscricoes {

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
    public void removeParticipante(String email) throws Exception {
        Participante p = pesquisaParticipante(email);
        this.participantes.remove(p);
    }

    @Override
    public void addParticipante(Participante i) throws Exception {
        try {
            Participante x = pesquisaParticipante(i.getEmail());
            throw new ParticipanteJaExistenteException("Já existe um participante com o e-mail: " + i.getEmail());
        } catch (ParticipanteNaoExistenteException e) {
            this.participantes.add(i);
        }
    }

    @Override
    public void inscreveParticipanteEmMinicurso(String emailPart, String tituloMinicurso) throws Exception {
        Participante x = pesquisaParticipante(emailPart);
        Minicurso o = pesquisarMinicurso(tituloMinicurso);
        //o.addParticipante(x);
        for (Minicurso i : this.minicursos) {
            if (i.getTitulo().equals(tituloMinicurso)) {
                i.addParticipante(x);
            }
        }

    }

    @Override
    public Participante pesquisaParticipante(String email) throws Exception {
        for (Participante i : this.participantes) {
            if (i.getEmail().equals(email)) {
                return i;
            }
        }
        throw new ParticipanteNaoExistenteException("Não existe participante com e-mail: " + email);
    }

    @Override
    public List<Participante> pesquisaParticipantesDaInstituicao(String instituicao) {
        List<Participante> x = new LinkedList<>();
        for (Participante i : this.participantes) {
            if (i.getInstituicao().equals(instituicao)) {
                x.add(i);
            }
        }
        return x;
    }

    @Override
    public List<Participante> pesquisaParticipantesDoEstado(String estado) {
        List<Participante> x = new LinkedList<>();
        for (Participante i : this.participantes) {
            if (i.getEndereco().getEstado().equals(estado)) {
                x.add(i);
            }
        }
        return x;
    }

    @Override
    public void addMinicurso(Minicurso i) throws MinicursoJaExisteException {
        try {
            Minicurso j = pesquisarMinicurso(i.getTitulo());
            throw new MinicursoJaExisteException("Já existe minicurso cadastrado com o título: " + i.getTitulo());
        } catch (MinicursoNaoExisteException e) {
            this.minicursos.add(i);
        }

    }

    @Override
    public Minicurso pesquisarMinicurso(String titulo) throws MinicursoNaoExisteException {
        for (Minicurso i : this.minicursos) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) {
                return i;
            }
        }
        throw new MinicursoNaoExisteException("Não existe minicurso com o título: " + titulo);
    }

    @Override
    public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException {
        List<Participante> nova = this.pesquisarMinicurso(tituloMinicurso).getParticipantes();
        return nova;
    }

    @Override
    public List<String> nomesToString() throws Exception {
        if(this.participantes.isEmpty()){
            throw new Exception("Não há participantes");
        }
        List<String> a = new LinkedList<>();
        this.participantes.forEach((i) -> {
            a.add(i.getNome());
        });
        return a;
    }
    
}
