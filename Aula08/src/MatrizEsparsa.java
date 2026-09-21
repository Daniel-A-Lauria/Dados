public class MatrizEsparsa {
	//propriedade da classe
	private Diretor cabeca = null;
	private int modulo = 0;
	
	//metodo construtor cheio da classe
	public MatrizEsparsa(int modulo) {
		this.modulo = modulo;
	}
	
	//metodos da classe 
	private Diretor procurarDiretor(int numero) {
		int resto = (numero % modulo);
		
		Diretor ponteiro = cabeca; 
		while ((ponteiro != null) && (ponteiro.getResto() != resto)) { //dois cenarios de procura, não achou e achou
			ponteiro = ponteiro.getProximoDiretor();
		}
		
		//cenário de resto encontrado
		if (ponteiro != null) {
			return ponteiro;
		}
		
		//cenário de resto não encontrado
		cabeca = new Diretor(resto, null, cabeca); //criou um novo diretor, por não ter achado, nasceu apontando pra nulo por não ter No 
		return cabeca;
	}
	
	public void inserir(int numero) {
		Diretor ponteiroDiretor = procurarDiretor(numero);
		
		ponteiroDiretor.setProximoNo(new No(numero, ponteiroDiretor.getProximoNo())); //setProximoNo: novo nó, getProximoNo: Nó anterior
	}
	
	public void excluir(int numero) {
		Diretor ponteiroDiretor = procurarDiretor(numero);
		
		//MUITO Facil (lista vazia)
		if (ponteiroDiretor.getProximoNo() == null) {
			return;
		}
		
		//Facil (Excluir o primeiro ou caso só tenha um)
		if (ponteiroDiretor.getProximoNo().getNumero() == numero) {
			ponteiroDiretor.setProximoNo(ponteiroDiretor.getProximoNo().getProximo()); //aponta para o repróximo
			return; 
		}
		
		//procura do número a ser excluido
		No anterior = ponteiroDiretor.getProximoNo();
		while ((anterior.getProximo() != null) && //chegou até o fim da lista e n achou 
				(anterior.getProximo().getNumero() != numero)) { //achou o número e parou no anterior
			anterior = anterior.getProximo();
			}		
		//dífici: numero não encontrado
		if (anterior.getProximo() == null) {
			return;
		}
		
		//dificil: numero foi encontrado
		anterior.setProximo(anterior.getProximo().getProximo()); //vai direto pro repróximo, matou o cara que tava na frente
		}
	
		public void imprimir() {
			System.out.println("Resto \t Números");
			Diretor ponteiroDiretor  = cabeca;
			while (ponteiroDiretor != null) { //linhas da matriz
				System.out.print(ponteiroDiretor.getResto() + "\t");
				No ponteiroNo = ponteiroDiretor.getProximoNo();
				while (ponteiroNo != null) { //colunas da matriz
					System.out.print(ponteiroNo.getNumero() + ", ");
					ponteiroNo = ponteiroNo.getProximo();
				}
				System.out.println();
				ponteiroDiretor = ponteiroDiretor.getProximoDiretor();
		}
	}
}
