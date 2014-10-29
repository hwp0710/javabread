package secondalgorithm.Chap08.tree;

public class TreeTest {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(1, 21);
		tree.insert(2, 11);
		tree.insert(3, 11);
		tree.insert(4, 5);
		tree.insert(5, 84);
		tree.insert(6, 13);
		tree.insert(7, 12);
		tree.insert(8, 77);
		tree.inOrder(tree.root);
		System.out.println("-----------------------------");
		tree.preOrder(tree.root);
		System.out.println("-----------------------------");
		tree.postOrder(tree.root);

		System.out.println("-----------------------------");

		Node find = tree.find(13);
		find.display();
	}

	static class Node {
		int index;
		int data;
		Node leftChild;
		Node rightChild;

		Node(int index, int ddata) {
			this.index = index;
			this.data = ddata;
		}

		void display() {
			System.out.println("index=" + index + ";data=" + data);
		}

		@Override
		public String toString() {
			return "index=" + index + ";data=" + data;
		}
	}

	static class Tree {
		Node root;

		Tree() {
			root = null;
		}

		Node find(int key) {
			Node current = root;
			while (key != current.data) {
				if (key < current.data) {
					current = current.leftChild;
				} else {
					current = current.rightChild;
				}
				if (current == null) {
					return null;
				}
			}
			return current;
		}

		void insert(int index, int value) {
			Node newNode = new Node(index, value);
			if (root == null)
				root = newNode;
			else {
				Node current = root;
				Node parent;
				while (true) {
					parent = current;
					if (value < current.data) {//go left
						current = current.leftChild;
						if (current == null) {
							parent.leftChild = newNode;
							return;
						}
					} else {//go right
						current = current.rightChild;
						if (current == null) {
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		}

		boolean delete(int value) {
			return false;
		}

		void display() {
		}

		void preOrder(Node node) {
			if (node != null) {
				node.display();
				preOrder(node.leftChild);
				preOrder(node.rightChild);
			}
		}

		void inOrder(Node node) {
			if (node != null) {
				inOrder(node.leftChild);
				node.display();
				inOrder(node.rightChild);
			}
		}

		void postOrder(Node node) {
			if (node != null) {
				postOrder(node.leftChild);
				postOrder(node.rightChild);
				node.display();
			}
		}

	}
}
