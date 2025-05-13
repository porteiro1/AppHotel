import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;
        Hotel hotel = new Hotel();
        System.out.println("Bem-vindo ao Gerenciamento de Hotel");
        while(rodando){
            int escolha = 0;
            System.out.println("""
                Você quer:
                1- adicionar Quarto
                2- adicionar Hospede
                3- fazer Reserva
                4- cancelar Reserva
                5- concluir Reserva
                6- monstrar quartos
                7- monstrar hospedes
                8- monstrar reservas
                9- monstrar historico
                10- parar gerenciamento
                """);
            escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> {
                    sc.nextLine();
                    String tipo;
                    System.out.println("Qual o tipo que deseja adicionar? (simples - duplo - luxo): ");
                    tipo = sc.next();
                    if(tipo.equalsIgnoreCase("simples")){
                        hotel.addQuarto(Tipo.SIMPLES);
                        System.out.println("Quarto " + hotel.quartosDisponiveis.getLast().getNumero() + " adicionado com sucesso!");
                    }else if(tipo.equalsIgnoreCase("duplo")){
                        hotel.addQuarto(Tipo.DUPLO);
                        System.out.println("Quarto " + hotel.quartosDisponiveis.getLast().getNumero() + " adicionado com sucesso!");

                    }else if(tipo.equalsIgnoreCase("luxo")){
                        hotel.addQuarto(Tipo.LUXO);
                        System.out.println("Quarto " + hotel.quartosDisponiveis.getLast().getNumero() + " adicionado com sucesso!");
                    }else{
                        System.out.println("Tipo invalido");
                    }

                } //add Quarto
                case 2 -> {
                    sc.nextLine();
                    String nome;
                    String cpf;
                    String telefone;
                    System.out.print("Digite o nome do hospede(apenas o primeiro nome) ");
                    nome = sc.next();
                    System.out.print("Digite o cpf do hospede ");
                    cpf = sc.next();
                    System.out.print("Digite o telefone do hospede ");
                    telefone = sc.next();
                    hotel.addHospede(nome, cpf, telefone);
                    System.out.println("Hospede adicionado com sucesso!");
                } //add Hospede
                case 3 -> {
                    String nome;
                    int numero;
                    int dias;
                    System.out.println("Qual o nome do hospede: ");
                    nome = sc.next();
                    System.out.print("Digite o numero do quarto: ");
                    numero = sc.nextInt();
                    System.out.print("Digite quantos dias vai passar: ");
                    dias = sc.nextInt();
                    hotel.addReserva(nome, numero, dias);

                } //Reserva
                case 4 -> {
                    int numero;
                    System.out.println("Qual é o numero do quarto: ");
                    numero = sc.nextInt();
                    hotel.cancelarReserva(numero);
                } //cancelar reserva
                case 5 -> {
                    System.out.println("Qual o numero do quarto?");
                    int numero = sc.nextInt();
                    hotel.concluirReserva(numero);
                } //concluir reserva
                case 6 -> hotel.mostraQuartos();
                case 7 -> hotel.mostraHospedes();
                case 8 -> hotel.mostraReservas();
                case 9 -> hotel.mostraHistorico();
                case 10 -> hotel.mostraQuartosDisponiveis();
                case 11 -> {
                    hotel.salvarHistorico();
                    hotel.salvarReservas();
                    hotel.salvarHospedes();
                    hotel.salvarquartosDiponiveis();
                    rodando = false;
                }

                default -> System.out.println("escolha enexistente");
            }
        }

    }
}