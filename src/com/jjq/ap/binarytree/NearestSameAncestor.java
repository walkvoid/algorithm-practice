public class NearestSameAncestor {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = buildTree();
        BinaryTreeNode<Integer> num6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> num4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node = nearestSameAncestor(root, num6, num4);
        System.out.println(node);
    }


    /**
     * 寻找两个节点p和q最近的公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static  BinaryTreeNode<Integer> nearestSameAncestor(BinaryTreeNode<Integer> root,
                                                               BinaryTreeNode<Integer> p,
                                                               BinaryTreeNode<Integer> q) {
        if (root == null) {
            return null;
        }
        if (p.equals(root) || q.equals(root)) {
            return root;
        }
        BinaryTreeNode<Integer> left = nearestSameAncestor(root.getLeft(), p, q);
        BinaryTreeNode<Integer> right = nearestSameAncestor(root.getRight(), p, q);
        if (left !=null && right !=null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    public static  BinaryTreeNode<Integer> buildTree() {

        BinaryTreeNode num3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode num5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode num1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode num6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode num2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode num0 = new BinaryTreeNode(0, null, null);
        BinaryTreeNode num8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode num7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode num4 = new BinaryTreeNode(4, null, null);

        num3.setLeft(num5);
        num3.setRight(num1);

        num5.setLeft(num6);
        num5.setRight(num2);

        num1.setLeft(num0);
        num1.setRight(num8);

        num2.setLeft(num7);
        num2.setRight(num4);
        return num3;
    }
}