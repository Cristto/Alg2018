package inicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LeerFichero {

    private static int k;
    private static int elementos;

    public List<Joya> leerBotin(String nombre) {

        List<Joya> aux = new ArrayList<>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            elementos = Integer.parseInt(bufferreader.readLine());
            //Joya[] aux = new Joya[elementos];


            k=Integer.parseInt(bufferreader.readLine());


            for (int i = 0; i < elementos; i++) {
                String linea = bufferreader.readLine();
                String campos[] = linea.split(" ");
                Joya producto = new Joya(
                        Integer.parseInt(campos[0]),
                        Integer.parseInt(campos[1]));
                //aux[i] = producto;
                aux.add(producto);
            }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public static int getK() {
        return k;
    }

    public static int getElementos() {
        return elementos;
    }
}
