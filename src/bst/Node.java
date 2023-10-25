package bst;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private int left_size;
	private int right_size;
	
	public Node() {
		left_size = 0;
		right_size = 0;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getLeft_size() {
		return left_size;
	}
	public void setLeft_size(int left_size) {
		this.left_size = left_size;
	}
	public int getRight_size() {
		return right_size;
	}
	public void setRight_size(int right_size) {
		this.right_size = right_size;
	}
	
	
}
