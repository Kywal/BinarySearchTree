package tests;

import bst.BinarySearchTree;

public class PrintTests {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);


		bst.imprimeArvore(1);
	}

}
