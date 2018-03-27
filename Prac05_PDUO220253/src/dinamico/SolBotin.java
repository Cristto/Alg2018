package dinamico;

import inicio.Joya;
import inicio.LeerBotin;

public class SolBotin {

    private int[] r = new int[LeerBotin.getN()+1];

    /**
     * el maximo entre (i-1,j) y ((i-1,j-w)) + v)
     * y si j-w <0  = (i-1,j)
     *
     */
    public int[][] solDinamico(Joya[] a, int fila, int col){

        //la matriz tiene una fila mas y una columna mas
        int[][] botin = new int[fila+1][col+1];

        for (int i = 0; i < fila+1; i++) {
            for (int j = 0; j < col + 1; j++) {
                if (i == 0) {
                    botin[i][j] = 0; //la fila cero la relleno a ceros
                    r[i] = 0;
                }
                if (i > 0) {
                    if (j - a[i].getPeso() < 0) //si j-Wi < 0
                        botin[i][j] = botin[i - 1][j]; //rellenamos esa posición con su valor de la fila anterior
                    else {
                        int v1 = botin[i - 1][j]; //guardamos el valor de (i-1,j), el primer valor a comparar
                        int v2 = botin[i - 1][j - a[i].getPeso()]; //guardamos el valor de (i-1,j-Wi)
                        int v3 = a[i].getValor(); //guardamos el valor de la joya de esa fila
                        int v4 = v2 + v3; //este es el sengundo valor a comparar


                        int max;
                        //Saco el mayor entre v1 y v4, si v1 es mas pequeño o igual cogemos v4 y si no v1
                        if(v1>=v4){
                            max = v1;
                            r[i] = 0;
                        }else{
                            max = v4;
                            r[i] = a[i].getPeso();
                        }
                        botin[i][j] = max; //guardo ese valor en la posición actual

                    }
                }
            }
        }

        return botin;
    }

    public void imprimirMatriz(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print( a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void imprimirR(){
        System.out.println();
        System.out.print("r = [");
        for (int i = 1; i < r.length; i++) {
            System.out.print(r[i] + "\t");
        }
        System.out.print("]");
    }
}
