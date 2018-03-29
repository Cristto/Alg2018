package dinamico;

import inicio.Joya;
import inicio.LeerBotin;

public class SolBotin {

    private int[] r = new int[LeerBotin.getN() + 1];

    /**
     * el maximo entre (i-1,j) y ((i-1,j-w)) + v)
     * y si j-w <0  = (i-1,j)
     */
    public int[][] solDinamico(Joya[] a, int fila, int col) {

        //la matriz tiene una fila mas y una columna mas
        int[][] botin = new int[fila + 1][col + 1];

        for (int i = 0; i < fila + 1; i++) {
            for (int j = 0; j < col + 1; j++) {
                if (i == 0) {
                    botin[i][j] = 0; //la fila cero la relleno a ceros
                }

                if (i > 0) {
                    if (j - a[i].getPeso() < 0) { //si j-Wi < 0
                        botin[i][j] = botin[i - 1][j]; //rellenamos esa posición con su valor de la fila anterior

                    } else {
                        int v1 = botin[i - 1][j]; //guardamos el valor de (i-1,j), el primer valor a comparar
                        int v2 = botin[i - 1][j - a[i].getPeso()]; //guardamos el valor de (i-1,j-Wi)
                        int v3 = a[i].getValor(); //guardamos el valor de la joya de esa fila
                        int v4 = v2 + v3; //este es el sengundo valor a comparar

<<<<<<< HEAD
=======

                        int max;
>>>>>>> 88d7d03142d86d6ecd5dd823d2af71033adfa82c
                        //Saco el mayor entre v1 y v4, si v1 es mas pequeño o igual cogemos v4 y si no v1
                        int max = v4 > v1 ? v4 : v1;

                        botin[i][j] = max; //guardo max en la posición actual
                    }
                }
            }
        }

        return botin;
    }

    public void imprimirMatriz(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

<<<<<<< HEAD
    public void imprimirV(int[][] a, Joya[] joya, int fila, int col) {

        int colAux = col;
        int filaAux;

        for (int i = fila; i >= 0; i--) {
            filaAux = i;
            for (int j = col; j >= 0; j--) {
                if(filaAux - 1 >= 0) {
                    if (a[filaAux][colAux] != a[filaAux - 1][colAux]) {
                        r[filaAux] = joya[filaAux].getPeso();
                        filaAux -= 1;
                        colAux -= joya[i].getPeso();
                    }
                }
            }
        }

    }


    public void imprimirR() {
=======
    public void imprimirR(){
        System.out.println();
>>>>>>> 88d7d03142d86d6ecd5dd823d2af71033adfa82c
        System.out.print("r = [");
        for (int i = 1; i < r.length; i++) {
            System.out.print(r[i] + "\t");
        }
        System.out.print("]");
        System.out.println();
    }
}
