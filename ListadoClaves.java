package sol;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListadoClaves {

    private char[] str; //array abecedario

    private char[] resFinal;
    private int totalElementos;
    private boolean finalizado;
    private int solucionesFinales;
    private String cadena; //cambio
    private char[] cadenaChar; //cambio
    private int cadenaTam; //cambio
    private int contador; //contador que aumenta una unidad por contraseña formada

    public ListadoClaves(int totalElementos, String cadena){
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        str = abecedario.toCharArray();
        this.totalElementos = totalElementos;
        this.resFinal = new char[totalElementos];
        this.solucionesFinales = 5; //cambio
        this.cadena = cadena; //cambio
        cadenaTam = cadena.length(); //cambio
        cadenaChar = cadena.toCharArray(); //cambio
        for (int i = 0; i < cadena.length(); i++) { //cambio
            resFinal[i] = cadenaChar[i]; //cambio
        }
    }

    private void generadorClave(int nivel) {

        //compruebo que nivel sea igual al total de elementos
        //y contador no sea igual al numero de contraseñas creadas
        if (nivel == totalElementos) {
            finalizado = true;
            contador++;
            mostrarClave(resFinal); //muestro cada contraseña

        } else {

            char[] aux = new char[totalElementos]; //cambio
            //si entra aqui es porque aun tengo letras que formar, barajo el array del abecedario
            //y lo clono al array auxiliar
            if (nivel < totalElementos) {
                barajador(str);
                aux = str.clone();
            }
            for (int i = 0; i < aux.length; i++) { //recorro el array ya barajado
                if (!finalizado) {
                    if (esValido(resFinal, aux[i], nivel)) { //compruebo las condiciones
                        resFinal[nivel] = aux[i]; //si cumple guardo el elemento en la posición de nivel
                        generadorClave(nivel + 1); //avanzamos al siguiente nivel
                    }
                } else if (contador != solucionesFinales) {
                    finalizado = false;
                    generadorClave(cadenaTam);
                }
            }
        }
    }

    private boolean esValido(char[] resFinal, char elemento, int nivel) {


        if(nivel>=1){ //cambio
            if(elemento == resFinal[nivel-1]) //cambio
                return false; //cambio
        }


        if (nivel >= 2) {
            if (esVocal(elemento) && esVocal(resFinal[nivel - 1]) && esVocal(resFinal[nivel - 2]))
                return false;
            if (esConsonante(elemento) && esConsonante(resFinal[nivel - 1]) && esConsonante(resFinal[nivel - 2]))
                return false;
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
        for (int i = 0; i < str.length; i++) {
            if (elemento != 'a' && elemento != 'e' && elemento != 'i' && elemento != 'o' && elemento != 'u') {
                if (str[i] == elemento) {
                    return true;
                }
            }
        }
        return false;
    }

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

    private void mostrarClave(char[] resFinal) {

        for (int i = 0; i < resFinal.length; i++) {
            System.out.print(resFinal[i]);
        }
        System.out.println();

    }

    private int getCadenaTam() {
        return cadenaTam;
    }

    public static void main(String[] args) {

        int total= Integer.parseInt (args[0]); //cambio
        String cadena= args[1]; //cambio


        ListadoClaves sol;
        if(total <= cadena.length())
            System.out.println("introduzca un long mayor");
        else {
            sol = new ListadoClaves(total, cadena); //cambio
            int nivel = sol.getCadenaTam(); //cambio
            sol.generadorClave(nivel); //cambio
        }


    }
}
