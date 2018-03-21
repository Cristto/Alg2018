package inicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LeerBotin {

    private static int k;
    private static int n;
    private static  BufferedReader lector;

    public static Joya[] leerBotin(String nombre) {

        Joya[] joya ;
        try {
            lector = new BufferedReader(new FileReader(nombre));
            n = Integer.parseInt(lector.readLine());
            joya = new Joya[n];
            k=Integer.parseInt(lector.readLine());

            for (int i = 0; i < n; i++) {
                String linea = lector.readLine();
                String campos[] = linea.split(" ");
                Joya producto = new Joya(i,
                        Integer.parseInt(campos[0]),
                        Integer.parseInt(campos[1]));
                //aux[i] = producto;
                joya[i] = producto;
            }
            return joya;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lector.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static int getK() {
        return k;
    }

    public static int getN() {
        return n;
    }
}
