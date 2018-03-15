package devoradores;

import inicio.Joya;
import inicio.LeerFichero;

import java.util.List;

public class Devorador1 {

    private int posicion; //posicion de un elemento de la lista para borrar
    int[] pesos = new int[LeerFichero.getElementos()];
    double sumaTotal = 0;

    public void dev(List<Joya> lista) {

        int pesoMaximo = LeerFichero.getK(); // peso maximo del fichero
        int contador = 0; // contador para saber si hay o no solucion

        while (!lista.isEmpty() && !haySolucion(contador)) {
            // eliminar aqui de la lista y fraccionar el ultimo

            Joya x = nextElemento(lista); //retorno la joya con mayor heuristico
            contador += x.getPeso(); //sumo el peso de la joya al contador

            if (contador <= pesoMaximo) {
                imprimirSolucion(x);
                lista.remove(posicion); //si no un atributo id en Joya
            }else {
                calcularParticion(x,contador); //aqui parto el ultimo elemento
                lista.remove(posicion);
            }
        }

        if(haySolucion(contador))
            System.out.println("Finaliza el primer devorador");

    }


    // saca el elemento con el mayor heuristico y lo borro para no tener lo despues
    private Joya nextElemento(List<Joya> lista) {

        // System.out.println("Máximo: " + lista.stream().mapToDouble(i ->
        // i.getHeuristico()).h().getAsDouble());

        double h = 0;
        Joya aux = null;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getHeuristico() > h) {
                h = lista.get(i).getHeuristico();
                aux = lista.get(i);
                posicion = i;
            }
        }

        return aux;
        // System.out.println("heuristico "+ h +" "+ "peso "+ pesoAux + " " + "valor "+
        // valorAux);

    }

    private void calcularParticion(Joya elemento, int contador) {
        //aqui hago la particion
        //del ultimo elemento tomado resto el peso para igualarlo al peso maximo
        //y con el peso obtenido lo multiplico al valor del objeto / peso anterior
        int pesoAux = 0;
        double valorAux = 0;

        pesoAux = contador - LeerFichero.getK();
        elemento.setPeso(pesoAux);
        valorAux = elemento.getPeso() * elemento.getHeuristico();
        elemento.setValor(valorAux);

        imprimirSolucion(elemento);
    }

    private void imprimirSolucion(Joya elemento) {
        // aqui saco el resultado y elimino cada elemento de la lista que valga
        //saco un array de pesos y la suma de los valores


        sumaTotal += elemento.getValor();
        System.out.println("valor final: " + sumaTotal);
    }

    private boolean haySolucion(int count){
        if (count == LeerFichero.getK())
            return true;
        else
            return false;

    }

}
