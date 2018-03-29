package medicion;


import dinamico.SolBotin;
import inicio.Joya;


public class Tiempo {

    public static void main(String[] args) {


        long t1, t2;
        //int[][] din = new int[n][k];

        int peso;
        int valor;
        int k;


        for (int i = 10; i < Integer.MAX_VALUE; i *= 2) {

            k = i;
            Joya[] joya = new Joya[k];
            int j;

            for (j = 0; j < i; j++) {
                peso = (int) (Math.random() * 89 + 10);
                valor = (int) (Math.random() * 89 + 10);
                joya[j] = new Joya(j, peso, valor);
            }


            //Cambiar aquí el tamaño de las repeticiones
            int nVeces = 1000;


            t1 = System.currentTimeMillis();
            for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {


            SolBotin d = new SolBotin();
             int[][] a = d.solDinamico(joya, j-1, k);
            }

            t2 = System.currentTimeMillis();

            System.out.println("n= " + i + "\t" + (t2 - t1));
        }
    }
}

