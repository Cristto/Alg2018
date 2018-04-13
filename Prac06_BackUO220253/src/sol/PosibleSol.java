package sol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PosibleSol {


    /*GeneradorClave 6 2 15
    el 6 seria el numero total de caracteres de la clave
    el 2 el numero de caracteres no alfabeticos con los que termina la clave
    siempre menor que el numero total
    el 15 es el numero de claves que saca

     */

    private List<String> parejasConsonantes = new ArrayList<String>();
    private char[] str; //array abecedario
    private char[] num; //array no abecedario
    private char[] resFinal; //array donde van las contraseñas finales
    private int totalElementos; //numero de elementos en total para formar la contraseña
    //4. Los dos últimos caracteres son signos de puntuación o números.
    private int elementosNoLetras; //numero de elementos que no son letras
    private boolean finalizado;
    private int solucionesFinales; //numero de contraseñas para mostrar
    private int contador; //contador que aumenta una unidad por contraseña formada


    /**
     * Constructor
     *
     * @param totalElementos    numero de elementos que forma la contraseña
     * @param elementosNoLetras numero de elementos que no son letras
     * @param solucionesFinales numero de contraseñas ya formadas listas para mostrar
     */
    public PosibleSol(int totalElementos, int elementosNoLetras, int solucionesFinales) {
        this.totalElementos = totalElementos;
        this.elementosNoLetras = elementosNoLetras;
        this.solucionesFinales = solucionesFinales;
        contador = 0;
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        str = abecedario.toCharArray();
        String numeros = "0123456789.,;:¿?¡!()";
        num = numeros.toCharArray();
        leerFichero("src/consonantes.txt");
        resFinal = new char[totalElementos];
        finalizado = false;

    }


    private void generadorClave(int nivel) {//nivel es una posicion, empieza en cero

        //compruebo que nivel sea igual al total de elementos
        //y contador no sea igual al numero de contraseñas creadas
        if (nivel == totalElementos/* && contador != solucionesFinales*/) {
            finalizado = true;
            contador++;
            mostrarClave(resFinal); //muestro cada contraseña

        } else {
            int totalAux = totalElementos - elementosNoLetras;
            char[] aux;
            //si entra aqui es porque aun tengo letras que formar, barajo el array del abecedario
            //y lo clono al array auxiliar
            if (nivel < totalAux) {
                barajador(str);
                aux = str.clone();
            } else {
                //si entra aqui es porque ya tengo las no letras que formar, barajo el array del  no abecedario
                //y lo clono al array auxiliar
                barajador(num);
                aux = num.clone();
            }
            for (int i = 0; i < aux.length; i++) { //recorro el array ya barajado
                if (!finalizado) {
                    if (esValido(resFinal, aux[i], nivel)) { //compruebo las condiciones
                        resFinal[nivel] = aux[i]; //si cumple guardo el elemento en la posición de nivel
                        generadorClave(nivel + 1); //avanzamos al siguiente nivel
                    }
                } else if(contador != solucionesFinales){
                    finalizado = false;
                    generadorClave(0);
                }
            }
        }
    }

    /**
     * Muestro las contraseñas ya creadas
     *
     * @param resFinal array con el resultado  final de contraseñas ya formadas
     */
    private void mostrarClave(char[] resFinal) {

        for (int i = 0; i < resFinal.length; i++) {
            System.out.print(resFinal[i]);
        }
        System.out.println();

    }


    /**
     * Condiciones:
     * 1. Solo pueden aparecer dos vocales seguidas si son diferentes
     * 2. No puede haber ni tres vocales ni tres consonantes seguidas
     * 3. Existe un conjunto de parejas de consonantes que pueden aparecer seguidas.
     *
     * @param resFinal array donde se van guardando las contraseñas finales
     * @param elemento la letra o no letra que se quiere comprobar
     * @param nivel    el nivel en el que estamos
     * @return false si cumple alguna condición o true si no cumple ninguna
     */
    private boolean esValido(char[] resFinal, char elemento, int nivel) {

        //Condicion 1.
        if (nivel >= 1) {
            if (esVocal(elemento)) {
                if (elemento == resFinal[nivel - 1]) {
                    return false;
                }
            }
        }
        //Condicion 2.
        if (nivel >= 2) {
            if (esVocal(elemento) && esVocal(resFinal[nivel - 1]) && esVocal(resFinal[nivel - 2]))
                return false;
            if (esConsonante(elemento) && esConsonante(resFinal[nivel - 1]) && esConsonante(resFinal[nivel - 2]))
                return false;
        }
        //Condicion 3.
        if (nivel >= 1) {
            if (!esVocal(elemento) && !esConsonante(elemento)) //arreglar la regla esConsonante
                return true;
            if (esConsonante(elemento) && esConsonante(resFinal[nivel - 1])) {//cumple siempre esta pq no es una vocal
                if (!parejasConsonantes.contains(String.valueOf(resFinal[nivel-1]) + String.valueOf(elemento))) { //aqui nunca encuentra la pareja
                    return false; //siempre retorna false
                }
            }
        }


        return true;
    }

    /**
     * Compruebo que el elemento pasado por parámetro sea una vocal
     *
     * @param elemento letra o no letra
     * @return true si es una vocal
     */
    private boolean esVocal(char elemento) {
        return elemento == 'a' || elemento == 'e' || elemento == 'i' || elemento == 'o' || elemento == 'u';
    }

    /**
     * Compruebo si el elemento pasado por parámetro sea una consonante
     *
     * @param elemento letra o no letra
     * @return true si es una consonante
     */
    private boolean esConsonante(char elemento) {
       // return elemento != 'a' && elemento != 'e' && elemento != 'i' && elemento != 'o' && elemento != 'u';
        for (int i = 0; i < str.length; i++){
            if(elemento != 'a' && elemento != 'e' && elemento != 'i' && elemento != 'o' && elemento != 'u'){
                if(str[i] == elemento){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Lee el fichero de las parejas de consonantes
     *
     * @param nombre el archivo de texto
     */
    private void leerFichero(String nombre) {

        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            for (int i = 0; i < nombre.length(); i++) {
                String linea = bufferreader.readLine();
                parejasConsonantes.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isFinalizado() {
        return finalizado;
    }


    //Fisher–Yates shuffle
    private void barajador(char[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        PosibleSol sol = new PosibleSol(6, 2, 15);
        sol.generadorClave(0);

    }
}
