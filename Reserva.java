import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private int dias;
    private String hora;
    private Status status;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDate data;

    public Reserva(Hospede hospede, Quarto quarto, int dias) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = dias;
        this.hora = LocalTime.now().format(formato);
        this.status = Status.ATIVA;
        this.data = LocalDate.now();
    }

    public double valorReserva() {
        return quarto.getPreco() * dias;
    }

    public String toString() {
        return  "------------------------------------------------------------------\n" +
                " | Hospede: " + hospede.getNome() + "\n" +
                " | CPF: " + hospede.getCpf() + "\n" +
                " | Quarto: " + quarto.getNumero() + "\n" +
                " | Dias: " + dias + "\n" +
                " | data: " + data + "\n" +
                " | Hora: " + hora + "\n" +
                " | Status: " + status + "\n" +
                " | Total: R$" + valorReserva() +
                "\n------------------------------------------------------------------";
    }

    public Hospede getHospede() {
        return hospede;
    }
    public int getDias() {
        return dias;
    }
    public String getHora() {
        return hora;
    }
    public Status getStatus() {
        return status;
    }
    public LocalDate getData() {
        return data;
    }
    public Quarto getQuarto() {
        return quarto;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toCSV(){
        return hospede.getNome() + "," + quarto.getNumero() + "," + dias + "," + data + "," + hora + "," + status.toString();
    }
}
