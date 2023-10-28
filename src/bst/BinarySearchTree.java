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
	
	
	/**
	 * Remove o valor especificado se ele existir. Caso contrário, não faz nada
	 * @param value Valor para ser removido
	 * @return booleano que indica se algum valor foi removido ou não
	 */
	public boolean remove(int value) {
		return auxRemove(root, null, value);
	}
	
	private boolean auxRemove(Node curr, Node parent, int key) {
		if(curr.getValue() == key) {
			if(curr.getLeft() == null && curr.getRight() == null) {
				// Caso 1 : É folha
				if(parent == null) {
					root = null;
				} else {
					if(parent.getValue() > key) {
						parent.setLeft(null);
					} else {
						parent.setRight(null);
					}
				}
			} else if (curr.getLeft() == null) {
				// Caso 2 : Somente possui a subárvore direita
				if(parent == null) {
					root = root.getRight();
				} else {
					if(parent.getValue() > key) {
						parent.setLeft(curr.getRight());
					} else {
						parent.setRight(curr.getRight());
					}
				}
			} else if (curr.getRight() == null) {
				// Caso 3 : Somente possui a subárvore esquerda
				if(parent == null) {
					root = root.getLeft();
				} else {
					if(parent.getValue() > key) {
						parent.setLeft(curr.getLeft());
					} else {
						parent.setRight(curr.getLeft());
					}
				}
			} else {
				// Caso 4 : Possui as duas subárvores
				int newValue = getLeftmost(curr.getRight());
				curr.setValue(newValue);
				auxRemove(curr.getRight(), curr, newValue);
				curr.setRightSize(curr.getRightSize() - 1);
			}
			
			
			return true;
		}
		
		if(key > curr.getValue() && curr.getRight() != null) {
			boolean removed = auxRemove(curr.getRight(), curr, key);
			if(removed) {
				curr.setRightSize(curr.getRightSize() - 1);
			}
			return removed;
		}
		
		if(key < curr.getValue() && curr.getLeft() != null) {
			boolean removed = auxRemove(curr.getLeft(), curr, key);
			if(removed) {
				curr.setLeftSize(curr.getLeftSize() - 1);
			}
			return removed;
		}
		
		return false;
	}
	
	private int getLeftmost(Node n) {
		if(n.getLeft() == null) return n.getValue();
		return getLeftmost(n.getLeft());
	}
	// Só para teste, lembrar de deletar antes de enviar o trabalho
	public void setRoot(Node n) {
		root = n;
	}
	
	public Node getRoot() {
		return root;
	}
	
	/**
	 * Imprime os nós em pré-ordem.
	 * @param n O nó raiz da subárvore atual
	 */
	public void preOrder(Node n) {
		System.out.println(n.toString());
		if(n.getLeft() != null) preOrder(n.getLeft());
		if(n.getRight() != null) preOrder(n.getRight());
	}
	
}
