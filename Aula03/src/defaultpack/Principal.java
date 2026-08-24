package defaultpack;

public class Principal {
	public static void main(String[] args) {
		Lista objLista = new Lista();
		
		//1o teste
		objLista.imprimir();
		objLista.inserir(1);
		objLista.inserir(2);
		objLista.inserir(3);
		objLista.inserir(4);
		objLista.inserir(5);
		objLista.imprimir();		
		objLista.excluir(1);
		objLista.excluir(3);
		objLista.excluir(5);
		objLista.excluir(10);
		objLista.imprimir();
		
		//2o teste
		for (int i = 0 ; i < 1000000 ; i++) {
			objLista.inserir(i);
			System.out.println(i);
		}
	}
}
