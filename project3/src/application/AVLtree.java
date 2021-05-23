package application;

public class AVLtree<T extends Comparable<T>> {
	private Node root;
	private String sort;
	
	public AVLtree(T data) {
		this.root = new Node(data);
	}
	
	public AVLtree() {
		
	}
	
	public void insert(T data) { // insert method
		if(root == null) root = new Node<>(data);
		else {
			Node rootNode = root;
			addEntry(data, rootNode);
			root = rebalance(rootNode);
		}
	} // end method
	
	private void addEntry(T data, Node node){ // insert method 
		assert node != null;
		if(data.compareTo((T)node.getData()) < 0){ // right into left subtree
		if(node.getLeft() != null){
			Node leftChild = node.getLeft();
			addEntry(data, leftChild);
			node.setLeft(rebalance(leftChild));
		}
		else node.setLeft(new Node(data));
		}
		else { // right into right subtree
			if(node.getRight() != null){
				Node rightChild = node.getRight();
				addEntry(data, rightChild);
				node.setRight(rebalance(rightChild));
			}
			else node.setRight(new Node(data));
		}
	} // end method
	
	private Node rebalance(Node node){ // ReBalanced method
		int diff = getHeightDifference(node);
		if ( diff > 1) { // addition was in node's left subtree
			if(getHeightDifference(node.getLeft())>0)
				node = rotateRight(node);
			else
				node = rotateLeftRight(node);
		}
		else if ( diff < -1){ // addition was in node's right subtree
			if(getHeightDifference(node.getRight())<0)
				node = rotateLeft(node);
			else
				node = rotateRightLeft(node);
		}
		return node;
	} // end method
	
	private int getHeightDifference(Node node) {
		if(node == null)
			return 0;
		return height(node.getLeft()) - height(node.getRight());
	}

	public Node Search(T data) { // Search method
		if(root == null)
			return null;
		else
			return Search(data, root);
	} // end method
	
	private Node Search(T data, Node node) { // Search method
		if(node == null)
			return null;
		if(node.getData().compareTo(data) == 0)
			return node;
		if(node.getData().compareTo(data) > 0) 
			return Search(data, node.getLeft());
		
		 
			return Search(data, node.getRight());
	} // end method
	
	public String inOrder() {
		sort = "";
		inOrder(root);
		return sort;
	}
	
	private void inOrder(Node node) { // Sort method
		if(node != null) {
			inOrder(node.getLeft());
			sort += node+"\n";
			inOrder(node.getRight());
		}
	} // end method
	
	public Node delete(T data) {
		Node temp = deleteEntry(data);
		if(temp!= null){
			Node rootNode = root;
			root = rebalance(rootNode);
		}
		return temp;
	}

	
	private Node deleteEntry(T data) { // delete method
		Node<T> curr = root;
		Node<T> parent = root;
		boolean isLeft = false;
		if(root == null) return null;
		while( curr != null && data.compareTo(curr.getData()) != 0) {
			parent = curr;
			if(curr != null && curr.getData().compareTo(data) < 0) {
				curr = curr.getRight();
				isLeft = false;
			}
			if(curr != null && curr.getData().compareTo(data) > 0) {
				curr = curr.getLeft();
				isLeft = true;
			}
		}
		if(curr == null) return null;
		// Case 1: Leaf Node
		if(curr.getLeft() == null && curr.getRight() == null) {
			if(curr == root)
				root = null;
			else {
				if(isLeft)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
		}
		// Case 2: has one Child
		else if (curr.getLeft() != null && curr.getRight() == null) { // current has left child only
			 if (curr == root)
				 root = curr.getLeft();
			 else if (isLeft) 
				 parent.setLeft(curr.getLeft());
			  else 
				 parent.setRight(curr.getLeft());
		} 
		else if (curr.getRight() != null && curr.getLeft() == null) { // current has left child only
			 if (curr == root)
				 root = curr.getRight();
			 else if (isLeft) 
				 parent.setLeft(curr.getRight());
			  else 
				 parent.setRight(curr.getRight());
			 
		} 
		// Case 3: has two Child
		else {
			Node successor = getSuccessor(curr);
			if (curr == root)
				root = successor;
			 else if (isLeft) 
				 parent.setLeft(successor);
			 else 
				 parent.setRight(successor);
			
			 successor.setLeft(curr.getLeft());
		}
		return curr;
	} // end method
	
	private Node getSuccessor(Node node) {
		Node parentOfSuccessor = node;
		Node successor = node;
		Node current = node.getRight();
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != node.getRight()) { // fix successor connections
			parentOfSuccessor.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}
	
	private Node rotateRight(Node N) { // Right Rotate
		Node<T> C = N.getLeft();
		N.setLeft(C.getRight());
		C.setRight(N);
		return C;
	} // end method
	
	private Node rotateLeft(Node N) { // Left Rotate
		Node<T> C = N.getRight();
		N.setRight(C.getLeft());
		C.setLeft(N);
		return C;
	} // end method
	
	private Node rotateRightLeft(Node N) { // Right Left Rotate
		Node<T> C = N.getRight();
		N.setRight(rotateRight(C));
		return rotateLeft(N);
	} // end method
	
	private Node rotateLeftRight(Node N) { // Left Right  Rotate
		Node<T> C = N.getLeft();
		N.setLeft(rotateLeft(C));
		return rotateRight(N);
	} // end method
	
	public int height() { 
		return height(root);  
	}
	
	private int height(Node node) {
		if (node == null) return 0;
		if (node.getLeft() == null && node.getRight() == null) return 1;
		int left = 0;
		int right = 0;
		if (node.getLeft() != null)
			left = height(node.getLeft());
		if (node.getRight() != null)
			right = height(node.getRight());
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
}
