package sol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PosibleSol {


    /*GeneradorClave 6 2 15
    el 6 seria el numero total de caracteres de la clave
    el 2 el numero de caracteres no alfabeticos con los que termina la clave
    siempre menor que el numero total
    el 15 es el numero de claves que saca
    ///////////////////////////
    Condiciones:
    1. Solo pueden aparecer dos vocales seguidas si son diferentes
    2. No puede haber ni tres vocales ni tres consonantes seguidas
    3. Existe un conjunto de parejas de consonantes que pueden aparecer seguidas.
    4. Los dos últimos caracteres son signos de puntuación o números.
    * */

    /**
     *
     * @param parejas las parejas de consonantes
     * @param letras las que puedo usar para generar la clave
     * @param finales los numeros y signos usados al final para finalizar la clave
     * @param inicio la primera letra para generar la clave o el primer elemento
     * @param total el numero de caracteres totales para crear las claves
     * @param numFinal son los numeros y signos permitidos en la generacion de claves
     * @param salida el numero de claves finales que se crearan
     */
    public void GeneradorClave(List<String> parejas,
                               String letras,
                               String finales,
                               int inicio,
                               int total,
                               int numFinal,
                               int salida){

        if(inicio == total)
            GuardarClave();
        else{

        }
    }

    private void GuardarClave() {
    }


    public List<String> leerFichero(String nombre) {

        List<String> aux = new ArrayList<String>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(nombre));
            for (int i = 0; i < nombre.length(); i++) {
                String linea = bufferreader.readLine();
                aux.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public static void main(String[] args) {
        String nombre = "src/consonantes.txt";
        String str = "abcdefghijklmnñopqrstuvwxyz";
        String num = "0123456789.,;:¿?¡!()";
        PosibleSol sol = new PosibleSol();

    }
}
