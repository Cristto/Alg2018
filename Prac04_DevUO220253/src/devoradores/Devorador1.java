package devoradores;

import inicio.Impl_1;
import inicio.Joya;
import inicio.LeerBotin;

import java.util.ArrayList;
import java.util.List;

public class Devorador1 {

    Impl_1 impl1 = new Impl_1();
    private List<Joya> pesos = new ArrayList<>();
    double sumaTotal = 0;

    public void dev(List<Joya> lista, int pesoMaximo) {

        //int pesoMaximo = LeerBotin.getK(); // peso maximo del fichero
        int pesoMochila = 0; // peso actual de la mochila

        while (!lista.isEmpty() && !haySolucion(pesoMochila, pesoMaximo)) {
            // eliminar aqui de la lista y fraccionar el ultimo

            Joya joyaSelec = impl1.nextElemento(lista); //retorno la joya con mayor heuristico
            pesoMochila += joyaSelec.getPeso(); //sumo el peso de la joya al pesoMochila

            if (pesoMochila <= pesoMaximo) {
                // aqui saco el resultado y elimino cada elemento de la lista que valga
                //saco un array de pesos y la suma de los valores
                pesos.add(joyaSelec);
            }else {
                int pesoUltimaJoya = calcularParticion(joyaSelec,pesoMochila,pesoMaximo); //aqui parto el ultimo elemento
                pesoMochila -= pesoUltimaJoya;
            }
            sumaTotal += joyaSelec.getValor();
            imprimirSolucion(joyaSelec);
            lista.remove(impl1.getPosicion()); //si no un atributo id en Joya
        }

        if(haySolucion(pesoMochila,pesoMaximo))
           System.out.println("Finaliza el primer devorador");

    }

    public boolean haySolucion(int count, int pesoMaximo){
        if (count == pesoMaximo)
            return true;
        else
            return false;

    }

    public void imprimirSolucion(Joya elemento) {

        System.out.println("h: "+elemento.getHeuristico());

        System.out.print("pesos: ");
        System.out.print("(");
        for (Joya re : pesos) {
            System.out.print(re + ", ");
        }
        System.out.println(")");

        System.out.println("valor final: " + sumaTotal);

        System.out.println("/////////////////////////");
    }

    public int calcularParticion(Joya elemento, int contador, int pesoMaximo) {
        //aqui hago la particion
        //del ultimo elemento tomado resto el peso para igualarlo al peso maximo
        //y con el peso obtenido lo multiplico al valor del objeto / peso anterior
        int pesoAux;
        double valorAux;
        //resto el contador del peso maximo, luego al peso de la joya le resto
        //el valor calculado anterior para que sea igual que le peso maximo
        //y calculo el nuevo valor de la joya
        pesoAux = contador - pesoMaximo;
        elemento.setPeso(elemento.getPeso() - pesoAux);
        valorAux = elemento.getPeso() * elemento.getHeuristico();
        elemento.setValor(valorAux);
        pesos.add(elemento);

        return pesoAux;
    }


}
