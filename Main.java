import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;
        Hotel hotel = new Hotel("Hotel legal");
        System.out.println("Bem-vindo ao Gerenciamento de Hotel");
        while(rodando){
            int escolha = 0;
            System.out.println("""
                Você quer:
                1- adicionar Quarto
                2- adicionar Hospede
                3- adicionar Reserva
                4- monstrar quartos
                5- monstrar hospedes
                6- monstrar reservas
                7- parar gerenciamento
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
                        System.out.println("Quarto " + hotel.quartos.getLast().getNumero() + " adicionado com sucesso!");
                    }else if(tipo.equalsIgnoreCase("duplo")){
                        hotel.addQuarto(Tipo.DUPLO);
                        System.out.println("Quarto " + hotel.quartos.getLast().getNumero() + " adicionado com sucesso!");

                    }else if(tipo.equalsIgnoreCase("luxo")){
                        hotel.addQuarto(Tipo.LUXO);
                        System.out.println("Quarto " + hotel.quartos.getLast().getNumero() + " adicionado com sucesso!");
                    }else{
                        System.out.println("Tipo invalido");
                    }

                }
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
                }
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

                }
                case 4 -> hotel.mostraQuartos();
                case 5 -> hotel.mostraHospedes();
                case 6 -> hotel.mostraReservas();
                case 7 -> rodando = false;

                default -> System.out.println("escolha enexistente");
            }
        }

    }
}