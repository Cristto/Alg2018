package inicio;

import devoradores.Devorador1;
import devoradores.Devorador2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String nombre = "src/botin01.txt";
        LeerFichero l  = new LeerFichero();
        List<Joya> lista = l.leerBotin(nombre);

        Devorador1 d1 = new Devorador1();
        d1.dev(lista);
        //Devorador2 d2 = new Devorador2(lista);

        /*Impl i  = new Impl();

        i.listaOrdenadaSeleccion(lista);
        for (int j = 0; j < lista.size(); j++) {
            System.out.print(lista.get(j).getHeuristico()+ " , ");
        }
        */
    }
}
