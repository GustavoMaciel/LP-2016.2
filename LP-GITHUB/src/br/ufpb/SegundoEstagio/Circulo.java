package br.ufpb.SegundoEstagio;

/**
 *
 * @author gmnun
 */
public class Circulo implements FiguraGeometrica{
    private double raio;
    private static final double PI = 3.14;
    
    public Circulo(){
        this.raio = 0.0;
    }
    
    public Circulo(double raio){
        this.raio = raio;
    }
    
    public void setRaio(double raio){
        this.raio = raio;
    }    
    public double getRaio(){
        return this.raio;
    }
    
    @Override
    public double calculaArea(){
        return PI*(this.raio * this.raio);
    }
    
    @Override
    public String toString(){
        return "Círculo de raio: " + this.raio;
    }
}
