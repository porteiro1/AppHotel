public class Quarto {
    private static int proximoNumero = 1;
    private int numero;
    private Tipo tipo;
    private double preco;
    private boolean taOcupado;

    public Quarto(Tipo tipo) {
        this.numero = proximoNumero++;
        this.tipo = tipo;
        this.taOcupado = false;

        switch(tipo){
            case SIMPLES -> this.preco = 50;
            case DUPLO -> this.preco = 100;
            case LUXO -> this.preco = 200;
        }
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Tipo getTipo() {
       return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public boolean getTaOcupado() {
        return taOcupado;
    }
    public void setTaOcupado(boolean taOcupado) {
        this.taOcupado = taOcupado;
    }

    public String toString() {
        return numero + " - " + tipo + " - " + preco;
    }
}
