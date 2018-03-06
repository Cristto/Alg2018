package solDyV;

public class DyV {

    private int[][] calendario;

    public DyV(int n) {

        calendario = new int[n][n];
        /*for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==0)
                    calendario[0][j] = i;
                else
                    calendario[i][j] = -1;
            }
        }*/
    }

    private void combinar(int[][] a, int eqprimero, int equltimo, int diaprimero, int diaultimo, int eqInicial) {

        for (int j = diaprimero; j <= diaultimo; j++)
            a[eqprimero][j] = eqInicial + j - diaprimero;

        for (int i = eqprimero + 1; i <= equltimo; i++) {
            a[i][diaprimero] = a[i - 1][diaultimo];
            for (int j = diaprimero + 1; j <= diaultimo; j++) {
                a[i][j] = a[i - 1][j - 1];
            }
        }
    }


    private void mezclarec(int[][] a, int primero, int ultimo) {

        if (ultimo - primero == 1) { //caso base
            a[primero][1] = ultimo;
            a[ultimo][1] = primero;
        } else {
            int medio = (ultimo + primero) / 2;
            mezclarec(a, primero, medio);
            mezclarec(a, medio + 1, ultimo);

            combinar(a, primero, medio, medio, ultimo - 1, medio + 1);
            combinar(a, medio + 1, ultimo, medio, ultimo - 1, primero);

        }
    }

    public void iniciarCalendario() {
        mezclarec(calendario, 0, calendario.length-1);
    }

    public void imprimir() {
        for (int i = 0; i < calendario.length; i++) {
            for (int j = 0; j < calendario[i].length; j++) {
                System.out.print(calendario[i][j] + " ");
            }
            System.out.println();
        }
    }
}
