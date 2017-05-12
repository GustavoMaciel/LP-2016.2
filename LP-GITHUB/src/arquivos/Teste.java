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
            lista.add("Olá");
            lista.add("Tudo bem?");
            grav.gravaTextoEmArquivo(lista, "teste");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
