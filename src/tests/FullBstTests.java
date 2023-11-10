package tests;

import bst.BinarySearchTree;

public class FullBstTests {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(8);
		bst.insert(12);
		bst.insert(4);
		bst.insert(9);
		bst.insert(11);
		bst.insert(15);
		
		bst.imprimeArvore(1);
		System.out.println("Essa ABB eh cheia?");
		System.out.println(bst.ehCheia());
	}

}
