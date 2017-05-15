package arquivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class Testa2 {
    public static void main(String[] args) {
        Gravador lido = new Gravador();
        List<String> texto = new ArrayList<>();
        try{
            texto = lido.recuperaTextoDeArquivo("teste.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
        texto.forEach((i) -> {System.err.println(i);});
    }
    
}
