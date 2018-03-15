package inicio;

public class Joya {


    private int peso;
    private double valor;
    private double heuristico;

    public Joya(int peso, int valor) {

        this.peso = peso;
        this.valor = valor;
        heuristico = calcularHeuristico();
    }

    private double calcularHeuristico() {
        return getValor() / (double)getPeso();
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

    public double getHeuristico() {
        return heuristico;
    }

}
