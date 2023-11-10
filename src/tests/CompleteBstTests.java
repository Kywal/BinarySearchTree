package tests;

import bst.BinarySearchTree;

public class CompleteBstTests {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(32);
		bst.insert(13);
		bst.insert(5);
		bst.insert(41);
		bst.insert(20);
		bst.insert(60);
		
		bst.imprimeArvore(1);
		System.out.println(bst.ehCompleta());
	}

}
