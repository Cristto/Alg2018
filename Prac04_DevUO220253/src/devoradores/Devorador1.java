package devoradores;

import inicio.Impl;
import inicio.Joya;
import inicio.LeerFichero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Devorador1 {

    Impl impl = new Impl();

    public void dev(List<Joya> lista) {

        int pesoMaximo = LeerFichero.getK(); // peso maximo del fichero
        int contador = 0; // contador para saber si hay o no solucion

        while (!lista.isEmpty() && !impl.haySolucion(contador)) {
            // eliminar aqui de la lista y fraccionar el ultimo

            Joya x = impl.nextElemento(lista); //retorno la joya con mayor heuristico
            contador += x.getPeso(); //sumo el peso de la joya al contador

            if (contador <= pesoMaximo) {
                impl.imprimirSolucion(x);
                lista.remove(impl.getPosicion()); //si no un atributo id en Joya
            }else {
                int valor = impl.calcularParticion(x,contador); //aqui parto el ultimo elemento
                lista.remove(impl.getPosicion());
                contador -= valor;
            }
        }

        if(impl.haySolucion(contador))
            System.out.println("Finaliza el primer devorador");

    }




}
