package solBruto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PetancaBruto {


    private static String[][] tabla;
    private static String[] nombres;

    public static void main(String[] args) {

        String line;
        int n = 0;

        try {

            BufferedReader bufferreader = new BufferedReader(new FileReader("jugadores.txt"));
            line = bufferreader.readLine();

            n = Integer.parseInt(line);
            tabla = new String[n + 1][n];
            nombres = new String[n];


            int i = 0;
            while (((line = bufferreader.readLine()) != null) && i < n) {
                if(i==0) {
                    tabla[0][0] = "jugadores";
                    nombres[i] = line;
                    i++;
                }else {
                    tabla[0][i] = "Dia " + i;
                    nombres[i] = line;
                    i++;
                }

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        combinar(tabla, n);
        imprimir(tabla);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(nombres[i] + " " );
        }

    }


    private static void imprimir(String[][] v) {

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void combinar(String[][] v, int tam) {

        for (int i = 1; i <= tam ; i++)
            for (int j = 0; j < tam; j++)
                v[i][j] = nombres[(i+j)%tam];

    }


}
