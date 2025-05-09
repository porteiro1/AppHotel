public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private int dias;

    public Reserva(Hospede hospede, Quarto quarto, int dias) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = dias;
    }

    public double valorReserva() {
        return quarto.getPreco() * dias;
    }

    public String toString() {
        return  "------------------------------------------------------------------\n" +
                "Hospede: " + hospede.getNome() +
                " | CPF: " + hospede.getCpf() +
                " | Quarto: " + quarto.getNumero() +
                " | Dias: " + dias +
                " | Total: R$" + valorReserva() +
                "\n------------------------------------------------------------------";
    }
}
