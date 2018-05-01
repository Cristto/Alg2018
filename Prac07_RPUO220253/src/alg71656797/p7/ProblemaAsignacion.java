package alg71656797.p7;

import alg71656797.util.RamificaYPoda;
import com.sun.org.apache.xpath.internal.SourceTree;

public class ProblemaAsignacion extends RamificaYPoda{

    public static void main(String[] args) {

        ProblemaAsignacion problemaAsigna = new ProblemaAsignacion();

        // Ejecutamos el método que va recorriendo el espacio de soluciones con ramifica y poda
        problemaAsigna.ramificaYPoda(problemaAsigna.getNodoRaiz());

        System.out.println(problemaAsigna.mejorSolucion);
        problemaAsigna.mostrarTrazaSolucion();


    }

    public ProblemaAsignacion()
    {
        nodoRaiz = new EstadoAsignacion(); //costes iniciales
    }
}
