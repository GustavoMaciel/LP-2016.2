package br.ufpb.SegundoEstagio;

import java.util.List;

/**
 *
 * @author gmnun
 */
public class ProgramaDasFiguras {

    public static void main(String[] args) {
        GerenteDeFiguras gerente = new GerenteDeFiguras();
        Quadrado q1 = new Quadrado(2.0);
        gerente.addFigura(q1);
        Circulo c1 = new Circulo(1.0);
        gerente.addFigura(c1);
        System.out.println("Imprimindo círculo: " + c1);
        
        gerente.addFigura(new Circulo(2.0));
        gerente.addFigura(new Circulo(3.0));
        gerente.addFigura(new Quadrado(2.0));

        System.out.println("Área total: " + String.format("%.2f", gerente.calculaAreaTotalDeFiguras()).replace(",", "."));

        List<FiguraGeometrica> figuras = gerente.getFiguras();
        figuras.forEach((i) -> {
            System.out.println(i);
        });

    }
}
