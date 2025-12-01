package CP2;

import java.util.Stack;

public class CustomTree {

    private TreeNode _root;

    public CustomTree() {
        _root = null;
    }

    public void insert(double tf, String word) {
        _root = insert(_root, tf, word);
    }

    private TreeNode insert(TreeNode node, double tf, String word) {

        // Actualizar
        
        if (node == null) {
            TreeNode newNode = new TreeNode(tf);
            newNode.addWord(word);
            return newNode;
        }

        if (tf < node.getTf()) {
            node.setLeft(insert(node.getLeft(), tf, word));
        } else if (tf > node.getTf()) {
            node.setRight(insert(node.getRight(), tf, word));
        } else {
            node.addWord(word);
        }

        return node;
    }

    public String getInOrderTraversal() {
        return getInOrderTraversal(_root);
    }

    private String getInOrderTraversal(TreeNode root) {
        var builder = new StringBuilder();
        var stack = new Stack<TreeNode>();
        var node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            builder.append(node.getTf() + "\n ↳ " + node.getWords() + "\n\n");
            node = node.getRight();
        }
        return builder.toString();
    }
}