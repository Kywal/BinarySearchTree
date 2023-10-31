/**
 * @author Emanuel Kywal e Ian Gabriel
 */

package bst;

public class BinarySearchTree {	
	
	private Node root;
	private int size;
	
	
	/**
	 * @ Procura pelo valor na ABB
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
	 * @description Insere um novo valor na árvore. Caso o valor já esteja na árvore, não o insere.
	 * 
	 * @param value Valor a ser inserido.
	 * @return true Quando a inserção ocorrer com sucesso.
	 * @return false Quando o valor inserido já está na árvore, a inserção não ocorre. 
	 */
	public boolean insert(int value) {
		if(root == null) {
			root = new Node();
			root.setValue(value);
			return true; 			
		} else {
			return auxInsert(root, value);
		}
	}
	
	/**
	 * @description Função auxiliar que percorre recursivamente a árvore 
	 * até o local adequado da inserção e a executa.
	 * 
	 * @param curr Nó atual.
	 * @param value Valor a ser inserido.
	 * @return true Quando a inserção ocorrer com sucesso.
	 * @return false Quando o valor inserido já está na árvore, a inserção não ocorre. 
	 */
	private boolean auxInsert(Node curr, int value) {
		Node rightNode = curr.getRight();
		Node leftNode = curr.getLeft();
		
		if(value > curr.getValue()) {
			if(rightNode == null) { 
				Node newRightNode = new Node();
				newRightNode.setValue(value);
				
				curr.setRight(newRightNode);
				curr.setRightSize(curr.getRightSize() + 1);
				size++;
				return true;
			} else {
				boolean inserted = auxInsert(rightNode, value);
				if(inserted) {
					curr.setRightSize(curr.getRightSize() + 1);					
				}
				return inserted;								
			}
		} 
		else if(value < curr.getValue()) {
			if(leftNode == null) {
				Node newLeftNode = new Node();
				newLeftNode.setValue(value);

				curr.setLeft(newLeftNode);
				curr.setLeftSize(curr.getLeftSize() + 1);
				size++;
				return true;
			} else {
				boolean inserted = auxInsert(leftNode, value);
				if(inserted) {
					curr.setLeftSize(curr.getLeftSize() + 1);					
				}
				return inserted;								
			}
		}
		else return false;
	}

	
	/**
	 * Remove o valor especificado se ele existir. Caso contrário, não faz nada
	 * @param value Valor para ser removido
	 * @return booleano que indica se algum valor foi removido ou não
	 */
	public boolean remove(int value) {
		return auxRemove(root, null, value);
	}
	
	/**
	 * Função auxiliar que remove um elemento de uma subárvore e atualiza as subárvores do pai
	 * @param curr Nó raiz da subárvore a ser considerada
	 * @param parent O pai da raíz da subárvore
	 * @param key Chave para ser removida
	 * @return True se conseguiu remover um elemento, False caso contrário
	 */
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
			
			size = size - 1;
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
	
	/**
	 * Retorna o nó mais a esquerda de uma subárvore
	 * @param n Nó raíz da subárvore
	 * @return O que ta dizendo
	 */
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
	
	/**
	 * Retorna o n-ésimo elemento da árvore considerando a ordem simétrica
	 * @param n Posição do elemento
	 * @return O que da dizendo
	 */
	public int enesimoElemento(int n) {
		return auxEnesimo(root, n);
	}
	
	/**
	 * Função auxiliar que retorna o n-ésimo elemento de uma subárvore (ordem simétrica)
	 * @param n Nó raiz da subárvore
	 * @param pos Posição do valor
	 * @return O n-ésimo elemento da subárvore na ordem simétrica
	 */
	private int auxEnesimo(Node n, int pos) {
		if(n.getLeft() == null && n.getRight() == null) {
			return n.getValue();
		}
		
		if(pos == n.getLeftSize() + 1) {
			return n.getValue();
		}
		
		if(pos <= n.getLeftSize()) {
			return auxEnesimo(n.getLeft(), pos);
		}
		
		int newPos = pos - (n.getLeftSize() + 1);
		return auxEnesimo(n.getRight(), newPos);
	}
	
	
	/**
	 * Retorna a posição do elemento x na ordem simétrica
	 * @param x Valor a ser procurado
	 * @return A posição de x. Retorna -1 caso x não exista
	 */
	public int posicao(int x) {
		return auxPosicao(root, x, 0);
	}
	
	/**
	 * Função auxiliar que retorna a posição de x na ordem simétrica
	 * @param curr Nó raiz da subárvore atual
	 * @param key Chave a ser procurada
	 * @param acc Quantos valores vem antes de x na ordem simétrica FORA desta subárvore
	 * @return a posição x na ordem simétrica em relação a árvore inteira. -1 Caso x não exista
	 */
	private int auxPosicao(Node curr, int key, int acc) {
		if(curr.getValue() == key) {
			return curr.getLeftSize() + acc + 1;
		}
		
		if(key < curr.getValue() && curr.getLeft() != null) {
			return auxPosicao(curr.getLeft(), key, acc);
		}
		
		if(key > curr.getValue() && curr.getRight() != null) {
			return auxPosicao(curr.getRight(), key, acc + curr.getLeftSize() + 1);
		}
		
		return -1;
	}
	
	// Apenas para teste - Lembrar de remover
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Calcula a mediana dos valores considerando a ordem simétrica
	 * @return Isso aí mesmo
	 */
	public int mediana() {
		if(size % 2 == 0) {
			return (enesimoElemento(size / 2) + enesimoElemento(size / 2 + 1)) / 2;
		}
		
		return enesimoElemento(size / 2 + 1);
	}
	
	/**
	 * 
	 * @param rootValue
	 * @return
	 * @throws Exception
	 */
	public double media(int rootValue) throws Exception {
		double sum = 0.0;
		int nodeAmount = 0;
		Node root = find(rootValue);
		
		if(root != null) {
			sum = auxMedia(root);
			nodeAmount = root.getLeftSize() + root.getRightSize() + 1; 			
		} else {
			throw new NullPointerException("Valor inserido não pertence à árvore!");
		}
				
		return sum/nodeAmount;
	}
	
	 /**
	  * 
	  * @param root
	  * @return
	  */
	public double auxMedia(Node root) {
		double sum = 0.0;
		sum += root.getValue();
		
		if(root.getLeft() != null) sum += auxMedia(root.getLeft());
		if(root.getRight() != null) sum += auxMedia(root.getRight());
		
		return sum;
	}
}
