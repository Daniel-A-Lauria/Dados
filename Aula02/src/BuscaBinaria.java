import java.util.Scanner;

public class BuscaBinaria {
	public static void main(String[] args) {
		//declaração de variáveis
		Scanner leitor = new Scanner(System.in);
		int[] vetor = new int[10000000];
		int inicio = 0;
		int fim = (vetor.length - 1);
		int meio = ((inicio + fim) /2);
		int contador = 0;
		int parametroPesquisa = 0;
		
		//construção do vetor 
		for (int i = 0 ; i < vetor.length ; i++) {
			vetor[i] = i;
		}
		//Pesquisas
		do {
			System.out.print("Digite o parâmetro de pesquisa: ");
			parametroPesquisa = leitor.nextInt();
			
			inicio = 0;
			fim = (vetor.length - 1);
			contador = 0;
			
			while (inicio <= fim) {	
				meio = ((inicio + fim) / 2);		
				contador++;
				
				if (parametroPesquisa == vetor[meio]) {
					System.out.println("ACHEI Na posição " + meio + " depois de " + contador + " tentativas.");
					break;
				} else if (parametroPesquisa < vetor[meio]) {
					fim = (meio - 1);
				} else {
					inicio = (meio + 1);
				}
				
			}
		} while (parametroPesquisa != -1);		
		leitor.close();
	}
}
