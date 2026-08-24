import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		//declaração de variaveis
		Scanner leitor = new Scanner(System.in);
		Lista objLista = new Lista();
		int opcao = 0;
		
		//processamento
		while (opcao != 5) {
			System.out.println("+===============+");
			System.out.println("| Menu de opções|");
			System.out.println("+===============+");
			System.out.println("| 1 - inserir   |");
			System.out.println("| 2 - Excluir   |");
			System.out.println("| 3 - Imprimir  |");
			System.out.println("| 4 - 100k       |");
			System.out.println("| 5 - sair      |");
			System.out.println("+===============+");
			System.out.println("Digite a sua opção: ");
			opcao = leitor.nextInt();
			
			if (opcao == 1) {
				System.out.print("Digite um número para inserir: ");
				objLista.inserir(leitor.nextInt());
			} else if (opcao == 2) {
				System.out.print("Digite um número para excluir: ");
				objLista.excluir(leitor.nextInt());
			} else if (opcao == 3) {
				objLista.imprimir();
			} else if (opcao == 4) {
				for (int i = 0 ; i < 100000 ; i++) {
					objLista.inserir(i);
				}
			}
		}
		leitor.close();
	}
}
