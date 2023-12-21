import java.lang.Math;
import java.util.Arrays;

// a binary tree containing node value, left and right child
class ArrayTree {
    static int root = 0;
    static int[] tree = {};

    public ArrayTree(int[] array) {
        tree = new int[(int) Math.pow(2, array.length) - 1];
        for (int n : array) {
            insertNode(n, root);
        }
    }

    public void insertNode(int key, int node) {
        if (tree[node] == 0) {
            tree[node] = key;
            return;
        } else if (key <= tree[node]) { // insert to its left subtree
            node = (node * 2) + 1;
            insertNode(key, node);
        } else { // insert to its right subtree
            node = (node * 2) + 2;
            insertNode(key, node);
        }
    }

    // print Tree without the rest 0
    public int[] printTree() {
        if (tree.length == 0)
            return tree;
        int n = 0;
        for (int i = tree.length - 1; i > 0; i--) {
            if (tree[i] != 0) {
                n = i;
                break;
            }
        }
        return Arrays.copyOfRange(tree, 0, n + 1);
    }
}
