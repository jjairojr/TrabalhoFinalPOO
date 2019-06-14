import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Lista implements FuncoesDaLista {
	// Cria��o do ArrayList Lista
	ArrayList<EntradaDeTexto> lista = new ArrayList<EntradaDeTexto>();
	// Utiliza��o do Singleton
	private static Lista INSTANCE = new Lista();
	
	public static Lista getInstance() {
		return INSTANCE;
	}
	//Adicionando o objeto criado na lista
	public void salvarNaLista(EntradaDeTexto edt1) {
		lista.add(edt1);
	}
	//Pegando o index na ComboBox da Listagem
	public String selecionarNaLista(int i) {
		return lista.get(i).getTexto();
	}
	// Realiza��o da fun��o de impress�o do programa
	public String imprimirLista() {
		String str = "";
		for (EntradaDeTexto loop : lista) {
			str += "[Entrada n� " + (lista.indexOf(loop) + 1) + "] " + loop.getTexto() + " - " + loop.getDataFormat() + "\n";
		}
		return str;
	}
	// M�todo de checagem onde verifica se a lista � vazia
	public boolean verificarListaVazia() {
		if (lista.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
			return false;
		}
		else return true;
	}
	//Metodo ToString para exibir a posi��o da lista e seu texto
	@Override
	public String toString() {
		return "Lista [lista=" + lista.get(1).getTexto() + "]";
	}

}
