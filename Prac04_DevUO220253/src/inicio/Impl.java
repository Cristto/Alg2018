package inicio;


import java.util.ArrayList;
import java.util.List;

public class Impl {

    private int posicion; //posicion de un elemento de la lista para borrar
    private List<Integer> pesos = new ArrayList<>();
    double sumaTotal = 0;

    // saca el elemento con el mayor heuristico y lo borro para no tener lo despues
    public Joya nextElemento(List<Joya> lista) {

        // System.out.println("Máximo: " + lista.stream().mapToDouble(i ->
        // i.getHeuristico()).h().getAsDouble());

        double h = 0;
        Joya aux = null;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getHeuristico() > h) {
                h = lista.get(i).getHeuristico();
                aux = lista.get(i);
                posicion = i;
            }
        }

        return aux;
        // System.out.println("heuristico "+ h +" "+ "peso "+ pesoAux + " " + "valor "+
        // valorAux);

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
        pesoAux = contador - LeerFichero.getK();
        elemento.setPeso(elemento.getPeso() - pesoAux);
        valorAux = elemento.getPeso() * elemento.getHeuristico();
        elemento.setValor(valorAux);

        imprimirSolucion(elemento);
        return pesoAux;
    }

    public void imprimirSolucion(Joya elemento) {
        // aqui saco el resultado y elimino cada elemento de la lista que valga
        //saco un array de pesos y la suma de los valores
        pesos.add(elemento.getPeso());

        System.out.println("h: "+elemento.getHeuristico());

        System.out.print("pesos: ");
        System.out.print("(");
        for (Integer re : pesos) {
            System.out.print(re + ", ");
        }
        System.out.println(")");

        sumaTotal += elemento.getValor();
        System.out.println("valor final: " + sumaTotal);

        System.out.println("/////////////////////////");
    }

    public boolean haySolucion(int count){
        if (count == LeerFichero.getK())
            return true;
        else
            return false;

    }

    public int getPosicion() {
        return posicion;
    }

    private  void seleccion (Joya[] a)
    {
        int n=a.length;
        int posmin;
        for(int i=0;i<n-1;i++)
        {
            // buscar posición del mas pequeño
            posmin=i;
            for(int j=i+1;j <n;j++)
                if(a[j].getHeuristico()<a[posmin].getHeuristico())
                    posmin=j;
            intercambiar(a,i,posmin);
        }// for

    }

    private  void intercambiar (Joya[] v, int i, int j)
    {
        Joya t;
        t=v[i];
        v[i]=v[j];
        v[j]=t;
    }

    private  int particion(double[]v,int iz,int de)
    {
        int i;
        double pivote;
        //intercambiar (v, (iz+de)/2,iz);
        //el pivote es el de centro y se cambia con el primero
        pivote= v[iz];
        i= iz;
        for (int s= iz+1; s <= de; s++)
            if (v[s] <= pivote)
            {
                i++;
               // intercambiar(v,i,s);
            }
        //intercambiar(v,iz,i);//se restituye el pivote donde debe estar
        return i; // retorna la posicion en que queda el pivote
    }

    private  void rapirec (double[] v, int iz, int de)
    {
        int m;
        if (de>iz)
        {
            m=particion(v,iz,de);
            rapirec(v,iz,m-1);
            rapirec(v,m+1,de);
        }
    }

    public List<Joya> listaOrdenadaSeleccion(List<Joya> lista){

        int tam = LeerFichero.getElementos();
        Joya[] listaAux = new Joya[tam];
        List<Joya> res = new ArrayList<>();

        for (int i = 0; i < tam; i++) {
            listaAux[i] = lista.get(i);
        }

        seleccion(listaAux);

        for (int i = tam-1; i >= 0; i--) {
            res.add(listaAux[i]);
        }

        return res;
    }

}
