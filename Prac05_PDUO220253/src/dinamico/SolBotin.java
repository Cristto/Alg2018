package dinamico;

import inicio.Joya;
import inicio.LeerBotin;

public class SolBotin {



    public void solDinamico(Joya[] a, int fila, int col){

        int [][] botin = new int[fila+1][col+1];


        for (int i = 0; i < fila+1; i++) {
            for (int j = 0; j < col+1; j++) {
                if(i == 0)
                    botin[0][j] = 0;
                
            }
        }

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
