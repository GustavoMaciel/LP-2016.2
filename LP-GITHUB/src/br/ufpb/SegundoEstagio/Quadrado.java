package br.ufpb.SegundoEstagio;

/**
 *
 * @author gmnun
 */
public class Quadrado implements FiguraGeometrica{
    private double lado;
    
    public Quadrado(){
        this.lado = 0.0;
    }
    public Quadrado(double lado){
        this.lado = lado;
    }
    
    public void setLado(double lado){
        this.lado = lado;
    }
    public double getLado(){
        return this.lado;
    }
    
    @Override
    public double calculaArea(){
        return this.lado*this.lado;
    }
    
    @Override
    public String toString(){
        return "Quadrado de lado: " + this.lado;
    }
    
}

