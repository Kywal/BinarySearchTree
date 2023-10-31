package tests;

import bst.BinarySearchTree;

public class MediaTests {

	public static void main(String[] args) throws Exception {

		BinarySearchTree bst = new BinarySearchTree();
				
		bst.insert(5);
		bst.insert(3);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		bst.preOrder(bst.getRoot());

		try {			
			System.out.printf("\nMedia: %.1f", bst.media(5));			
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}

}
