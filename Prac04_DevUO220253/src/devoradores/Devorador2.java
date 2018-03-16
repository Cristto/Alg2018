package devoradores;

import inicio.Impl;
import inicio.Joya;
import inicio.LeerFichero;


import java.util.List;

public class Devorador2 {

    Impl impl = new Impl();

    public Devorador2(List<Joya> l){
        impl.listaOrdenadaSeleccion(l);
    }

    public void dev(List<Joya> lista) {

        int pesoMaximo = LeerFichero.getK(); // peso maximo del fichero
        int contador = 0; // contador para saber si hay o no solucion
        int x = 0;//esta mal


            while (!lista.isEmpty() && !impl.haySolucion(contador)) {
                // eliminar aqui de la lista y fraccionar el ultimo


                    contador += lista.get(x).getPeso(); //sumo el peso de la joya al contador

                    if (contador <= pesoMaximo) {
                        impl.imprimirSolucion(lista.get(x));
                        lista.remove(x); //no borro el elemento que tengo que borrar
                        x++;
                    } else {
                        int valor = impl.calcularParticion(lista.get(x), contador); //aqui parto el ultimo elemento
                        lista.remove(x);
                        contador -= valor;
                    }

            }


        if (impl.haySolucion(contador))
            System.out.println("Finaliza el segundo devorador");

    }
}
