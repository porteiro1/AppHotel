import java.util.ArrayList;

public class Hotel {
    private String nome;
    ArrayList<Quarto> quartos;
    ArrayList<Reserva> reservas;
    ArrayList<Hospede> hospedes;

    public Hotel(String nome){
        this.nome = nome;
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        hospedes = new ArrayList<>();
        addHospede("roberto","43","5");
        addHospede("cassio","43","5");
        addHospede("rabiso","43","5");
        addHospede("maia","43","5");
        addQuarto(Tipo.SIMPLES);
        addQuarto(Tipo.SIMPLES);
        addQuarto(Tipo.DUPLO);
        addQuarto(Tipo.DUPLO);
        addQuarto(Tipo.LUXO);
        addQuarto(Tipo.LUXO);
        addReserva("rabiso",5,2);

    }

    public void addHospede(String nome, String cpf, String telefone) {
        hospedes.add(new Hospede(nome, cpf, telefone));
    }

    public void addQuarto(Tipo tipo) {
        quartos.add(new Quarto(tipo));
    }

    public void addReserva(String nome, int numero, int dias) {
        Hospede hospede = null;
        for (Hospede h : hospedes) {
            if(h.getNome().equalsIgnoreCase(nome)) {
                hospede = h;
                break;
            }
        }
        if(hospede == null) {
            System.out.println("Hospede enexistente.");
            return;
        }

        Quarto quarto = null;
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                quarto = q;
                break;
            }
        }

        if(quarto == null) {
            System.out.println("Quarto enexistente.");
            return;
        }
            if(quarto.getTaOcupado()){
                System.out.println("Quarto ja ocupado.");
                return;
            }

        Reserva r = new Reserva(hospede, quarto, dias);
        reservas.add(r);
        quarto.setTaOcupado(true);
        System.out.println("Quarto reservado com sucesso.");
    }

    public void mostraQuartos() {
        for (Quarto q : quartos) {
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

    public String getNome(){
        return nome;
    }
}
