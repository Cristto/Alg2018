package inicio;

import java.util.Collections;
import java.util.List;

public class Impl_2 {


    public void seleccion(List<Joya> a) {
        int n = a.size();
        int posmin;
        for (int i = 0; i < n - 1; i++) {
            // buscar posición del mas pequeño
            posmin = i;
            for (int j = i + 1; j < n; j++)
                if (a.get(j).getHeuristico() < a.get(posmin).getHeuristico())
                    posmin = j;
            //intercambiar(a,i,posmin);
            Collections.swap(a, i, posmin);

        }// for

    }


}
