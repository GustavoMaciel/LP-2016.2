package Roteiro6;

/**
 *
 * @author gmnun
 */
public class Turma {

    private int numero, quantAlunos = 0;
    private Aluno[] alunos;
    private String nomeProf, nomeDisciplina;

    public Turma() {
        int maxAlunos = 100;
        alunos = new Aluno[maxAlunos]; //Inicializa o array indicando que podem existir no máximo 100 alunos
        quantAlunos = 0; //Inicializa a quantidade de alunos para ser 0 no início.
    }

    public int getNumero() {
        return numero;
    }

    public int getQuantAlunos() {
        return quantAlunos;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastrarAluno(Aluno aluno) {
        this.alunos[this.quantAlunos] = aluno;
        this.quantAlunos++;
    }

    public double getMediaDaTurma() {
        double soma = 0;
        for (Aluno aluno : this.alunos) {
            if (aluno != null) {
                soma += aluno.getMedia();
            } else {
                break;
            }
        }
        return soma / this.quantAlunos;
    }

    public void imprimeListaAlunos() {
        for (Aluno aluno : this.alunos) {
            if (aluno != null) {
                System.out.println("Nome: " + aluno.getNome() + "\nMedia: " + aluno.getMedia());
            } else {
                break;
            }
        }
    }

}
