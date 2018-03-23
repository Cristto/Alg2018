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

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    public String toString() {
        return "["+id+", "+peso+"]";
    }

}
