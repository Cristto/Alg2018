package inicio;

public class Joya {

    private int id;
    private int peso;
    private int valor;


    public Joya(int id, int peso, int valor) {
        this.id= id;
        this.peso = peso;
        this.valor = valor;

    }

    public int getPeso() {
        return peso;
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }




    public String toString() {
        return "["+id+", "+peso+"]";
    }

}
