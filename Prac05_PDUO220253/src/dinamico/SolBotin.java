package dinamico;

import inicio.Joya;

public class SolBotin {

    /**
     * el maximo entre (i-1,j) y ((i-1,j-w)) + v)
     * y si j-w <0  = (i-1,j)
     *
     */
    public int[][] solDinamico(Joya[] a, int fila, int col){

        int[][] botin = new int[fila+1][col+1];

        for (int i = 0; i < fila+1; i++) {
            for (int j = 0; j < col+1; j++) {
                if(i==0)
                    botin[i][j] = 0;
                if(i>0){
                    if(j - a[i].getPeso() < 0)
                        botin[i][j] = botin[i-1][j];
                    else{
                        int v1 = botin[i-1][j];
                        int v2 = botin[i-1][j-a[i].getPeso()];
                        int v3 = a[i].getValor();
                        int v4 = v2 + v3;

                        int max = v1 >= (v2+v4) ? v1 : v4;
                        botin[i][j] = max;

                    }
                }
            }
        }

        return botin;
    }

    public void imprimir(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
