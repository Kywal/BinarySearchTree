package bst;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private int leftSize;
	private int rightSize;
	private int height;
	private int subtreeSum;
	
	public Node() {
		leftSize = 0;
		rightSize = 0;
		subtreeSum = 0;
		height = 1;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSubtreeSum() {
		return subtreeSum;
	}
	public void setSubtreeSum(int subtreeSum) {
		this.subtreeSum = subtreeSum;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
		this.subtreeSum = value;
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
	
	public boolean isLeaf() { return this.getLeft() == null && this.getRight() == null; }
	
	public String toString() {
		return String.format("{ valor: %d, cnt_esquerda: %d, cnt_direita: %d }", value, leftSize, rightSize);
	}
}
