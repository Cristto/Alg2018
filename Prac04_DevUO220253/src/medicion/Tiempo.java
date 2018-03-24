package medicion;

import devoradores.Devorador3;
import devoradores.Devorador2;
import devoradores.Devorador1;
import inicio.Joya;

import java.util.ArrayList;
import java.util.List;

public class Tiempo {

    public static void main(String[] args) {


        long t1, t2;
        int peso, valor, k;



        for (int i = 10; i < Integer.MAX_VALUE; i *= 2) {

            List<Joya> lista = new ArrayList<Joya>();

            for (int j = 0; j < i; j++) {
                peso = (int) (Math.random() * 89 + 10);
                valor = (int) (Math.random() * 89 + 10);
                lista.add(new Joya(j, peso, valor));
            }


            k = 25 * i;

            //Cambiar aquí el tamaño de las repeticiones
            int nVeces = 10000000;
            //AVISO: para tomar los tiempos comentar estas tres lineas al
            //final de cada metodo dev
            //imprimirSolucion(joyaSelec);
            //if(haySolucion(pesoMochila,pesoMaximo))
            //System.out.println("Finaliza el primer devorador");

            t1 = System.currentTimeMillis();
            for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
                Devorador1 d = new Devorador1();
                //Devorador2 d = new Devorador2(lista);
                //Devorador3 d = new Devorador3(lista);

                d.dev(lista, k);
            }

            t2 = System.currentTimeMillis();

            System.out.println("n= " + i + "\t" + (t2 - t1));
        }
    }
}

