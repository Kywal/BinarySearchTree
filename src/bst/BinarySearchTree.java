package bst;

public class BinarySearchTree {
	private Node root;
	
	
	/**
	 * Procura pelo valor na ABB
	 * @param value O valor a ser procurado
	 * @return O objeto Node que contém o valor especificado
	 */
	public Node find(int value) {
		if(root == null) return null;
		return auxFind(root, value);
	}
	
	/**
	 * Função auxiliar para a busca. Busca a chave em uma subárvore
	 * @param curr Nó raiz da subárvore
	 * @param key Chave a ser procurada
	 * @return O objeto que contém o valor especificado
	 */
	private Node auxFind(Node curr, int key) {
		if(curr.getValue() == key) {
			return curr;
		}
		
		if(curr.getLeft() != null && key < curr.getValue()) {
			return auxFind(curr.getLeft(), key);
		}
		
		if(curr.getRight() != null && key > curr.getValue()) {
			return auxFind(curr.getRight(), key);
		}
		
		return null;
	}
	
	
	
	// Só para teste, lembrar de deletar antes de enviar o trabalho
	public void setRoot(Node n) {
		root = n;
	}
	
	public Node getRoot() {
		return root;
	}
	
	
	public void preOrder(Node n) {
		System.out.println(n.toString());
		if(n.getLeft() != null) preOrder(n.getLeft());
		if(n.getRight() != null) preOrder(n.getRight());
	}
	
}
