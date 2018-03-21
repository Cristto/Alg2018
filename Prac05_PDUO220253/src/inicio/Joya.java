package inicio;

public class Joya {

    private int id;
    private int peso;
    private double valor;


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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public String toString() {
        return "["+id+", "+peso+"]";
    }

}
