import java.util.Scanner;

public class BruteForce {
	public static void main(String[] args) {
		//Declar variaveis
		Scanner leitor = new Scanner(System.in);
		int[] vetor = new int[10000];
		int parametroPesquisa = 0;
		
		//construção do vetor
		for (int i = 0 ; i < vetor.length ; i++) {
			vetor[i] = ((int) (vetor.length * Math.random()));
		}
		
		//pesquisas
		do {
			System.out.print("Digite um parâmetro de pesquisa: ");
			parametroPesquisa = leitor.nextInt();
			
			for (int i = 0; i < vetor.length ; i++) {
				if (parametroPesquisa == vetor[i]) {
					System.out.println("ACHEI CUM !!! Na posição " + i);
					break;
				}
			}
		} while (parametroPesquisa != -1);
		
		leitor.close();
	}
}
