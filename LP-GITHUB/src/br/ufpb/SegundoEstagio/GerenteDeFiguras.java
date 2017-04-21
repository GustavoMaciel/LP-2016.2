package br.ufpb.SegundoEstagio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class GerenteDeFiguras {
    private List<FiguraGeometrica> figuras;

    public GerenteDeFiguras(List<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    public GerenteDeFiguras() {
        this.figuras = new ArrayList<>();
    }

    public List<FiguraGeometrica> getFiguras() {
        return this.figuras;
    }

    public void setFiguras(List<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }
    
    
    
    public void addFigura(FiguraGeometrica fig){
        this.figuras.add(fig);
    }
    
    public double calculaAreaTotalDeFiguras(){
        double soma = 0;
        for(FiguraGeometrica i: this.figuras){
            soma += i.calculaArea();
        }
        return soma;
    }
    
    
}
