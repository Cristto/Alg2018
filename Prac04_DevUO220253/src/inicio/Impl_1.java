package inicio;


import java.util.ArrayList;
import java.util.List;

public class Impl_1 {

    private int posicion; //posicion de un elemento de la lista para borrar

    // saca el elemento con el mayor heuristico y lo borro para no tener lo despues
    public Joya nextElemento(List<Joya> lista) {

        // System.out.println("Máximo: " + lista.stream().mapToDouble(i ->
        // i.getHeuristico()).heuristico().getAsDouble());

        double heuristico = 0;
        Joya joya = null;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getHeuristico() > heuristico) {
                heuristico = lista.get(i).getHeuristico();
                joya = lista.get(i);
                posicion = i;
            }
        }

        return joya;
        // System.out.println("heuristico "+ heuristico +" "+ "peso "+ pesoAux + " " + "valor "+
        // valorAux);

    }

    public int getPosicion() {
        return posicion;
    }



}
