import java.util.Stack;

public class Solution24 {
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void preorder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    void void levelOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            postorder(root.left);
            postorder(root.right);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node40 = new Node(40);
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        Node node70 = new Node(70);

        root.left = node20;
        root.right = node30;
        node20.left = node40;
        node20.right = node50;
        node40.left = node70;
        node30.right = node60;

        Solution24 pt = new Solution24();
        System.out.println("Preorder Traversal solution : ");
        pt.preorder(root);

        System.out.println("Inorder Traversal solution : ");
        pt.inorder(root);

        System.out.println("Postorder Traversal solution : ");
        pt.postorder(root);

        System.out.println("Levelorder Traversal solution : ");
        pt.levelOrder(root);
    }
}