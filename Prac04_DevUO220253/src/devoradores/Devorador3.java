package devoradores;

import inicio.Joya;
import inicio.LeerBotin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Devorador3 {

    private List<Joya> pesos = new ArrayList<>();
    double sumaTotal = 0;

    public Devorador3(List<Joya> l){

        //Asi me deja usar el sort en una lista vacia
        /*l.sort(new Comparator<Joya>() {
            @Override
            public int compare(Joya p1, Joya p2) {
                if (p1.getHeuristico() > p2.getHeuristico()) {
                    return -1;
                } else if (p1.getHeuristico() < p2.getHeuristico()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });*/

        //aqui optimizo el comparator pero antes quite el Collection
        /*Collections.sort(l, new Comparator<Joya>() {
            @Override
            public int compare(Joya o1, Joya o2) {
                return Double.compare(o2.getHeuristico(), o1.getHeuristico());

            }
        });*/

        //usando una funcion Lambda de menor a mayor
        l.sort((o1, o2) -> Double.compare(o2.getHeuristico(), o1.getHeuristico()));

    }

    public void dev(List<Joya> lista) {

        int pesoMaximo = LeerBotin.getK(); // peso maximo del fichero
        int pesoMochila = 0; // peso actual de la mochila
        int joya = 0;

        while (!lista.isEmpty() && !haySolucion(pesoMochila)) {


            Joya joyaSelec = lista.get(joya); //retorno la joya con mayor heuristico
            pesoMochila += joyaSelec.getPeso(); //sumo el peso de la joya al pesoMochila

            if (pesoMochila <= pesoMaximo) {
                // aqui saco el resultado y elimino cada elemento de la lista que valga
                //saco un array de pesos y la suma de los valores
                pesos.add(joyaSelec);
            }else {
                int pesoUltimaJoya = calcularParticion(joyaSelec,pesoMochila); //aqui parto el ultimo elemento
                pesoMochila -= pesoUltimaJoya;
            }
            sumaTotal += joyaSelec.getValor();
            imprimirSolucion(joyaSelec);
            joya++;
        }

        if(haySolucion(pesoMochila))
            System.out.println("Finaliza el primer devorador");

    }

    public boolean haySolucion(int count){
        if (count == LeerBotin.getK())
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

    public int calcularParticion(Joya elemento, int contador) {
        //aqui hago la particion
        //del ultimo elemento tomado resto el peso para igualarlo al peso maximo
        //y con el peso obtenido lo multiplico al valor del objeto / peso anterior
        int pesoAux;
        double valorAux;
        //resto el contador del peso maximo, luego al peso de la joya le resto
        //el valor calculado anterior para que sea igual que le peso maximo
        //y calculo el nuevo valor de la joya
        pesoAux = contador - LeerBotin.getK();
        elemento.setPeso(elemento.getPeso() - pesoAux);
        valorAux = elemento.getPeso() * elemento.getHeuristico();
        elemento.setValor(valorAux);
        pesos.add(elemento);

        return pesoAux;
    }
}
