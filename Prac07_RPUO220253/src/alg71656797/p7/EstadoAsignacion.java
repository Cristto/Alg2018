package alg71656797.p7;

import alg71656797.util.Estado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EstadoAsignacion extends Estado {

    private int n; //tamaño del problema
    private int[][] matriz; //matriz de costes
    private boolean[] marca; //tareas ya asignadas
    private int[] asig; //lo que se le va asignando a cada repartidor


    /**
     * Constructor para crear el estado inicial
     */
    public EstadoAsignacion() {
        super();
        LeerFichero("src/tiempos03.txt");
        asig = new int[n];
        marca = new boolean[n];
        for (int i = 0; i< asig.length; i++) {
            asig[i] = -1;
            marca[i] = false;
        }

    }

    /**
     * Constructor para crear un estado a partir del padre
     * @param padre
     * @param i
     */
    public EstadoAsignacion(EstadoAsignacion padre, int i) {
        super();
        n = padre.n;
        matriz = padre.matriz;
        asig = Arrays.copyOf(padre.asig, n);
        marca = Arrays.copyOf(padre.marca, n);
        profundidad = padre.profundidad;
        idPadre = padre.getId();			//se copian los valores del padre
        asig[profundidad]  = i;
        marca[i] = true;
        profundidad++;
        calcularValorHeuristico();	//actualiza con lo del hijo


    }


    @Override
    public void calcularValorHeuristico() {
        valorHeuristico = 0;

        for ( int i=0; i<profundidad; i++)
            //sumo los costes de los agentes con tareas
            valorHeuristico += matriz[i][asig[i]];

        //suma los minimos de lo que resta de cada columna por cada tarea no asignada
        for ( int j=0; j<n; j++)
            if ( !marca[j] )
                valorHeuristico+=calcularMinimoColumna(j,profundidad);
    }

    /**
     * Calcula el elemento minimo de una columna
     * @param j
     * @return
     */
    private int calcularMinimoColumna(int j, int profundidad) {
        int aux = Integer.MAX_VALUE;
        for ( int i=profundidad; i<n; i++) {
            if ( matriz[i][j] < aux )
                aux = matriz[i][j];
        }
        return aux;
    }

    @Override
    public ArrayList<Estado> expandir() {
        ArrayList<Estado> hijos = new ArrayList<Estado>();
        for ( int i=0; i<n; i++)
            if ( !marca[i]) {
                Estado hijo = new EstadoAsignacion(this,i);
                hijos.add(hijo);
            }

        return hijos;
    }

    @Override
    public boolean solucion() {
        return profundidad == n;
    }

    @Override
    public int valorInicialPoda() {

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++)
            d1 += matriz[i][i];

        for (int i = 0; i < n; i++)
            d2 += matriz[i][matriz.length - 1 - i];

        return d1 >= d2 ? d1 : d2;
    }

    private void LeerFichero(String nombre) {

        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            this.n = Integer.parseInt(bufferreader.readLine());
            this.matriz = new int[n][n];
            String[] linea;
            int repartidor = 0;
            while (bufferreader.ready()) {
                linea = bufferreader.readLine().split("\\t");
                for (int pedido = 0; pedido < n; pedido++) {
                    matriz[repartidor][pedido] = Integer.parseInt(linea[pedido]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NumberFormatException e){
            System.out.println("no es un numero");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<asig.length; i++)
        {
            if (asig[i] != -1)
                sb.append("Al repartidor "+i+" se le asigna el pedido "+asig[i]+"\n");
            else
                sb.append("El pedido "+i+" no tiene asignacion\n");
        }
        sb.append("Valor heuristico= " + valorHeuristico + "\n");
        sb.append("=======================================\n");
        return sb.toString();
    }
}
