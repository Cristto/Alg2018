package inicio;

import devoradores.Devorador1;
import devoradores.Devorador2;
import devoradores.Devorador3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LeerBotin {

    private static int k;

    public static void main(String[] args) {

        String nombre = "src/botin01.txt";
        List<Joya> lista = leerBotin(nombre);

        //Devorador1 d = new Devorador1();
        //Devorador2 d = new Devorador2(lista);
        Devorador3 d = new Devorador3(lista);
        d.dev(lista);

    }


    public static List<Joya> leerBotin(String nombre) {

        List<Joya> aux = new ArrayList<>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            int elementos = Integer.parseInt(bufferreader.readLine());
            //Joya[] aux = new Joya[elementos];


            k=Integer.parseInt(bufferreader.readLine());


            for (int i = 0; i < elementos; i++) {
                String linea = bufferreader.readLine();
                String campos[] = linea.split(" ");
                Joya producto = new Joya(i,
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

}
