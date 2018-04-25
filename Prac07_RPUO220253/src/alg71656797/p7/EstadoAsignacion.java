package alg71656797.p7;

import alg71656797.util.Estado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EstadoAsignacion extends Estado {

    private int[][] tabla;
    private int n;

    public EstadoAsignacion() {
        super();
        tabla = LeerFichero("src/tiempos01.txt");

    }

    @Override
    public void calcularValorHeuristico() {

    }

    @Override
    public ArrayList<Estado> expandir() {
        return null;
    }

    @Override
    public boolean solucion() {
        return false;
    }

    @Override
    public int valorInicialPoda() {

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++)
            d1 += tabla[i][i];

        for (int i = 0; i < n; i++)
            d2 += tabla[i][tabla.length - 1 - i];

        return d1 >= d2 ? d1 : d2;
    }

    private int[][] LeerFichero(String nombre) {


        int[][] matriz;
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            n = Integer.parseInt(bufferreader.readLine());
            matriz = new int[n][n];
            String[] linea;
            int repartidor = 0;
            while (bufferreader.ready()) {
                linea = bufferreader.readLine().split(" ");
                for (int pedido = 0; pedido < n; pedido++) {
                    matriz[repartidor][pedido] = Integer.parseInt(linea[pedido]);
                }
            }

            return matriz;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
