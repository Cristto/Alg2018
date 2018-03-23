package inicio;

import dinamico.SolBotin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeerBotin {

    private static int k;
    private static int n;


    public static void main(String[] args) {
        SolBotin sol = new SolBotin();
        String texto = "src/botin03.txt";
        Joya[] joya = leerBotin(texto);
        int[][] din = sol.solDinamico(joya, n, k);
        sol.imprimir(din);
    }

    private static Joya[] leerBotin(String nombre) {

        Joya[] joya ;
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            n = Integer.parseInt(bufferreader.readLine());
            joya = new Joya[n+1];
            k=Integer.parseInt(bufferreader.readLine());

            for (int i = 1; i < n+1; i++) {
                String linea = bufferreader.readLine();
                String campos[] = linea.split(" ");
                Joya producto = new Joya(i,
                        Integer.parseInt(campos[0]),
                        Integer.parseInt(campos[1]));
                //aux[i] = producto;
                joya[i] = producto;
            }
            return joya;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
