package arquivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmnun
 */
public class Teste {

    public static void main(String[] args) {
        Gravador grav = new Gravador();
        List<String> lista = new ArrayList<>();
        try {
            for(byte i =0; i < 7; i++){
            lista.add("Testando " + (i+1));
            }
            grav.gravaTextoEmArquivo(lista, "teste.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
