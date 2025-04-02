package agenda;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vetor vetor = new Vetor(50);
        int proximoIndice = 1; 

        while (true) {
            System.out.println("Escolha uma das opcoes abaixo: ");
            System.out.println("1. Incluir");
            System.out.println("2. Pesquisar");
            System.out.println("3. Alterar");
            System.out.println("4. Excluir");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.println("Digite a descricao do compromisso: ");
                String descricao = scanner.nextLine();
                System.out.println("Digite a data do compromisso (dd/mm/yyyy): ");
                String data = scanner.nextLine();
                System.out.println("Digite o horario do compromisso (hh:mm): ");
                String hora = scanner.nextLine();
                Agenda agenda = new Agenda(proximoIndice, descricao, data, hora);
                try {
                    vetor.adiciona(agenda);
                    System.out.println("Compromisso adicionado com sucesso");
                    proximoIndice++; 
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Digite o índice do compromisso a ser pesquisado: ");
                int indicePesquisa = scanner.nextInt();
                scanner.nextLine(); 
                Agenda compromisso = vetor.busca(indicePesquisa);
                if (compromisso != null) {
                    System.out.println("Compromisso encontrado: " + compromisso);
                } else {
                    System.out.println("Compromisso nao encontrado.");
                }
            } else if (opcao == 3) {
                System.out.println("Digite o índice do compromisso a ser alterado:");
                int indiceAlterar = scanner.nextInt();
                scanner.nextLine(); 
                Agenda compromissoAlterar = vetor.busca(indiceAlterar);
                if (compromissoAlterar != null) {
                    try {
                        System.out.println("Digite a nova descricao:");
                        String novaDescricao = scanner.nextLine();
                        System.out.println("Digite a nova data (dd/mm/yyyy):");
                        String novaData = scanner.nextLine();
                        System.out.println("Digite a nova hora (hh:mm):");
                        String novaHora = scanner.nextLine();
                        compromissoAlterar.setDescricao(novaDescricao);
                        compromissoAlterar.setData(novaData);
                        compromissoAlterar.setHora(novaHora);
                        System.out.println("Compromisso alterado com sucesso.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Compromisso nao encontrado.");
                }
            } else if (opcao == 4) {
                System.out.println("Digite o indice do compromisso a ser excluído:");
                int indiceExcluir = scanner.nextInt();
                scanner.nextLine(); 
                try {
                    vetor.remove(indiceExcluir);
                    System.out.println("Compromisso excluído com sucesso.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 5) {
                System.out.println("Encerrando o programa...");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Opcao inválida. Tente novsmente.");
            }
        }
    }
}