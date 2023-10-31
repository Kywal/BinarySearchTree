package tests;

import bst.*;

public class InsertTests {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
				
		// Empty tree
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(25);
		bst.insert(12);
		bst.insert(11);
		bst.preOrder(bst.getRoot());
		
		// Insert already existing value
		System.out.println(bst.insert(12));
		bst.preOrder(bst.getRoot());
		
	}

}
