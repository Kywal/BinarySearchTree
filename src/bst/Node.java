package bst;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private int leftSize;
	private int rightSize;
	
	public Node() {
		leftSize = 0;
		rightSize = 0;
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
	public int getLeftSize() {
		return leftSize;
	}
	public void setLeftSize(int left_size) {
		this.leftSize = left_size;
	}
	public int getRightSize() {
		return rightSize;
	}
	public void setRightSize(int right_size) {
		this.rightSize = right_size;
	}
	
	public String toString() {
		return String.format("{ valor: %d, cnt_esquerda: %d, cnt_direita: %d }", value, leftSize, rightSize);
	}
}
