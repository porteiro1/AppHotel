import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Hotel {
    ArrayList<Quarto> quartosDisponiveis;
    ArrayList<Reserva> reservas;
    ArrayList<Hospede> hospedes;
    ArrayList<Historico> historico;

    public Hotel() {
        quartosDisponiveis = new ArrayList<>();
        reservas = new ArrayList<>();
        hospedes = new ArrayList<>();
        historico = new ArrayList<>();
        addQuarto(Tipo.LUXO);
        addReserva("rabiso", 1, 2);

    }

    public void addHospede(String nome, String cpf, String telefone) {
        hospedes.add(new Hospede(nome, cpf, telefone));
    }

    public void addQuarto(Tipo tipo) {
        quartosDisponiveis.add(new Quarto(tipo));
    }

    public void addReserva(String nome, int numero, int dias) {
        Hospede hospede = null;
        for (Hospede h : hospedes) {
            if (h.getNome().equalsIgnoreCase(nome)) {
                hospede = h;
                break;
            }
        }
        if (hospede == null) {
            System.out.println("Hospede enexistente.");
            return;
        }

        Quarto quarto = null;
        for (Quarto q : quartosDisponiveis) {
            if (q.getNumero() == numero) {
                quarto = q;
                break;
            }
        }

        if (quarto == null) {
            System.out.println("Quarto enexistente.");
            return;
        }
        if (quarto.getTaOcupado()) {
            System.out.println("Quarto ja ocupado.");
            return;
        }

        Reserva r = new Reserva(hospede, quarto, dias);
        reservas.add(r);
        quarto.setTaOcupado(true);
        System.out.println("Quarto reservado com sucesso.");
    }

    public void cancelarReserva(int quarto) {
        Reserva reserva = null;
        for(Reserva r : reservas) {
            if(r.getQuarto().getNumero() == quarto) {
                reserva = r;
                r.setStatus(Status.CANCELADA);
                r.getQuarto().setTaOcupado(false);
                historico.add(new Historico(r));
                reservas.remove(r);
                break;
            }
        }

    }

    public void concluirReserva(int quarto) {
        Reserva reserva = null;
        for(Reserva r : reservas) {
            if(r.getQuarto().getNumero() == quarto) {
                reserva = r;
                r.setStatus(Status.CONCLUIDA);
                historico.add(new Historico(r));
                reservas.remove(r);
                break;
            }
        }
    }

    public void mostraQuartos() {
        for (Quarto q : quartosDisponiveis) {
            System.out.println(q.toString());
        }
    }

    public void mostraReservas() {
        for (Reserva r : reservas) {
            System.out.println(r.toString());
        }
    }

    public void mostraHospedes() {
        for (Hospede h : hospedes) {
            System.out.println(h.toString());
        }
    }

    public void mostraHistorico() {
        for (Historico h : historico) {
            System.out.println(h.toString());
        }
    }

    public void mostraQuartosDisponiveis() {
        for (Quarto q : quartosDisponiveis) {
            System.out.println(q.toString());
        }
    }

    public void salvarHistorico() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Historico.csv"))){
            writer.write("Nome,Quarto,Dias,Valor,Status,Data,Hora");
            writer.newLine();
            for (Historico h: historico){
                writer.write(h.toCSV());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Erro ao gravar Historico " + e.getMessage());
        }
    }

    public void salvarHospedes() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Hospedes.csv"))){
            for (Hospede h: hospedes){
                writer.write(h.toCSV());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Erro ao gravar Hospedes " + e.getMessage());
        }
    }

    public void salvarquartosDiponiveis() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("QuartosDisponiveis.csv"))){
            for (Quarto q: quartosDisponiveis){
                writer.write(q.toCSV());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Erro ao gravar quartos livres " + e.getMessage());
        }
    }

    public void salvarReservas() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("reservas.csv"))){
            for (Reserva r: reservas){
                writer.write(r.toCSV());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Erro ao gravar Reservas " + e.getMessage());
        }
    }
}
