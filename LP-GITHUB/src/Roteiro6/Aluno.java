package Roteiro6;

/**
 *
 * @author gmnun
 */
public class Aluno {
    private String matricula, nome;
    private double[] notas;
   
    public Aluno(){
        this.matricula = "";
        this.nome = "";
        this.notas = null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    
    public double getMedia(){
        double soma = 0;
        for(byte i = 0; i < this.notas.length; i++){
            soma += this.notas[i];
        }
        return soma/this.notas.length;
    }
    
}
