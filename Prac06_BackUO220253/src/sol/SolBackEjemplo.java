package sol;

public class SolBackEjemplo {

    /**
     * ejemplo de clase
     * {a,b,c,d,e}
     * {0,1,.}
     * 3 caracteres en total y el ultimo tiene que ser 0,1 ó .
     * ejemplo ab0,ab1,ab.
     * 1º resolver primero con letras y luego con numeros o .
     * 2º resolver en otro orden
     */

    int totalCar = 3;
    int carNumericos = 1;
    char[] clave; //estado
    private final static int LETRA_A = 97;//ascii de la letra a o 'a'

    void backtraking(int nivel){

        if(nivel == totalCar) //es solucion?
            guardarClave(clave);
        else{
            //comprobar siguiente caracter posible
            for (int k = 0; k <5-1/*grado arbol*/ ; k++) {
                //condiciones estado valido
                if(esValido(clave,(char)(LETRA_A + k))) { //clave: estado actual y la i sera la a, la b, la c la que sea
                    clave[nivel] = (char) (LETRA_A + k);
                    backtraking(nivel+1);
                    //borrar anotacion
                    //clave[nivel] = '\0';//caracter nulo
                }

            }
        }

    }

    private void guardarClave(char[] clave) {
    }

    private boolean esValido(char[] clave, char c) {
        
        return false;
    }
}
