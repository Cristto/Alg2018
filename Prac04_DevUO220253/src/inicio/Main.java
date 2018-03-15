package inicio;

import devoradores.Devorador1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String nombre = "src/prueba.txt";
        LeerFichero l  = new LeerFichero();
        List<Joya> lista = l.leerBotin(nombre);

        Devorador1 d = new Devorador1();
        d.dev(lista);

    }
}
