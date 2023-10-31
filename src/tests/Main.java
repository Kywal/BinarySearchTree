package tests;

import bst.BinarySearchTree;
import bst.Node;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.setSize(5);
		Node n1 = new Node();
		n1.setValue(5);
		n1.setLeftSize(1);
		n1.setRightSize(3);
		
		Node n2 = new Node();
		n2.setValue(3);
		
		Node n3 = new Node();
		n3.setValue(8);
		n3.setLeftSize(1);
		n3.setRightSize(1);
		
		Node n4 = new Node();
		n4.setValue(6);
		Node n5 = new Node();
		n5.setValue(9);
		
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n3.setLeft(n4);
		n3.setRight(n5);
		bst.setRoot(n1);
		
		bst.preOrder(bst.getRoot());
		//bst.remove(6);
		System.out.println("#############");
		bst.preOrder(bst.getRoot());
		System.out.println("#############");
		/*for(int i=1; i<=5; i++) {
			System.out.println(bst.enesimoElemento(i));
		}*/
		
		System.out.println(bst.posicao(5));
		System.out.println(bst.mediana());
	}

}
