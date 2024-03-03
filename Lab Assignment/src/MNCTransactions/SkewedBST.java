package MNCTransactions;
import MNCTransactions.Node;
public class SkewedBST {

    static Node prev = null;
    static Node head = null;

    //converting BST to skewed tree
    public Node skewedBST(Node root, int k) {
        //if tree is empty
        if (root == null) {
            return null;
        }

        //converting in descending order
        if (k > 0) {
            skewedBST(root.right, k);
        }
        //converting in ascending order
        else {
            skewedBST(root.left, k);
        }

        Node rightNode = root.right;
        Node leftNode = root.left;

        if(head == null) {
            head = root;
        }
        else {
            prev.right = root;
        }
        root.left = null;
        prev = root;

        if (k > 0) {
            skewedBST(leftNode, k);
        }
        else {
            skewedBST(rightNode, k);
        }
        return head;
    }
}
