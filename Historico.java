import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Historico {
    private Hospede hospede;
    private Quarto quarto;
    private int dias;
    private String hora;
    private Status status;
    private double valor;
    LocalDate data;

    public Historico(Reserva reserva){
        this.hospede = reserva.getHospede();
        this.quarto = reserva.getQuarto();
        this.dias = reserva.getDias();
        this.hora = reserva.getHora();
        this.status = reserva.getStatus();
        this.data = reserva.getData();
        this.valor = reserva.valorReserva();
    }
    @Override
    public String toString() {
        return "Histórico: " + hospede.getNome() + ", Quarto: " + quarto.getNumero() + ", Dias: " + dias +
                ", Valor: R$" + valor + ", Status: " + status + ", Encerrado em: " + data;
    }
    public String toCSV(){
        return hospede.getNome() + "," +
                quarto.getNumero() + "," +
                dias + "," +
                valor + "," +
                status + "," +
                data + "," +
                hora;
    }
}