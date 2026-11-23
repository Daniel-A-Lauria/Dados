import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	//propriedades da ckasse
	private boolean[][] matrizAdjacencia = null; //verdadeiro = tem conexão falso = adivinha
	
	//metodo construtor cheio da classe
	public Grafo(int qtdVertices) {
		matrizAdjacencia = new boolean[qtdVertices][qtdVertices];
	}
	
	//metodo da classe
	public void construir(boolean aleatorio) {
		boolean adjacencia = false;
		
		for (int i = 0 ; i < (matrizAdjacencia.length - 1) ; i++) { //i é das linhas, j é das colunas, navegação apenas pela diagonal superior
			for (int j = (i+1) ; j < matrizAdjacencia.length ; j++) {
				if (aleatorio) { //sorteia os numeros
					adjacencia = (((int) (3 * Math.random())) == 0);
				} else { //deixa os numeros ao input do usuario
					BufferedReader leitor = new BufferedReader(
											new InputStreamReader(System.in));
					try {
						System.out.print("Digite <S> se " + i + " for adjacente a " + j + ": "); //i é vertice da linha j é vertice da coluna
						adjacencia = leitor.readLine().equalsIgnoreCase("s");
					} catch (Exception e) {}
				}
				matrizAdjacencia[i][j] = adjacencia;
				matrizAdjacencia[j][i] = adjacencia;
			}
		}
	}
	
	public void imprimir() {
		System.out.println("Vértice \t Vizinhança");
		for (int i = 0 ; i < matrizAdjacencia.length ; i++){
			System.out.print(i + "\t\t ");
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					System.out.print(j + ", ");
				}
			}
			System.out.println();
		}
	}
	
	public void procurarMaiorGrau() {
		int vertice = 0;
		int maiorGrau = 0;
		
		for (int i = 0 ; i < matrizAdjacencia.length ; i++) {
			int contador = 0;
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					contador++;
				}
			}
			if (contador > maiorGrau) {
				vertice = i;
				maiorGrau = contador;
			}
		}
		System.out.println("O vértice mais popular é o " + vertice + ". " + "Ele tem grau " + maiorGrau + ". ");
	}
}
