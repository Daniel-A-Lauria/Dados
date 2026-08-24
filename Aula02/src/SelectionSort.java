import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		//declarar variaveis
		Scanner leitor = new Scanner(System.in);
		int[] vetor = new int[7];
		
		//entrada de dados
		for (int i = 0 ; i < vetor.length ; i++) {
			System.out.print("Digite o valor do índice " + i + ": ");
			vetor [i] = leitor.nextInt();
		}
		leitor.close();
		//Processamento
		for (int i = 0 ; i < (vetor.length - 1) ; i++) { //primeiro ao penultimo
			for (int j = (i + 1) ; j < vetor.length ; j++) { //próximo ao último
				if (vetor[i] > vetor[j]) {
					int temp = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = temp; // centro do algoritmo
				}
			}
		}
		
		//saída de dados 
		for (int i = 0 ; i < vetor.length ; i++) {
			System.out.println(vetor[i]);
		}
	}
}
