package application;

public class Node<T extends Comparable<T>> {
	private T data;
	private Node Right;
	private Node Left;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getRight() {
		return Right;
	}

	public void setRight(Node right) {
		Right = right;
	}

	public Node getLeft() {
		return Left;
	}

	public void setLeft(Node left) {
		Left = left;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	
	
	
}
