package tests;

import bst.BinarySearchTree;

public class PrintTests {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.insert(5));
		System.out.println(bst.insert(5));
		bst.insert(3);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		System.out.println(bst.remove(5));


		bst.imprimeArvore(1);
	}

}
