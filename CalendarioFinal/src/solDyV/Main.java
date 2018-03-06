package solDyV;

public class Main {

    //abreviatura main -> psvm
    //abreviatura System.out.println -> sout
    public static void main(String[] args) {

      int tam = 8;
      DyV calendario = new DyV(tam);

      calendario.iniciarCalendario();
      calendario.imprimir();
    }

}
