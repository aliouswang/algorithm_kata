package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeSolution {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeSolution treeSolution = new TreeSolution();

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        midTraverse(root, resultList);
        boolean isSorted = true;
        if (resultList.isEmpty() || resultList.size() == 1) return true;
        for (int i = 1; i < resultList.size(); i++) {
            if (resultList.get(i) <= resultList.get(i - 1)) return false;
        }
        return true;
    }

    private void midTraverse(TreeNode root, List<Integer> resultList) {
        if (root == null) return;
        if (root.left != null) {
            midTraverse(root.left, resultList);
        }
        resultList.add(root.val);
        if (root.right != null) {
            midTraverse(root.right, resultList);
        }
    }


//    public boolean isValidBST(TreeNode root) {
//        // write your code here
//        if (root == null) return true;
//        boolean leftValid = true;
//        boolean rightValid = true;
//        if (root.left != null) {
//            leftValid = isValidBST(root.left);
//            if (root.val <= root.left.val) {
//                leftValid = false;
//            }
//        }
//
//        if (root.right != null) {
//            rightValid = isValidBST(root.right);
//            if (root.val >= root.right.val) {
//                rightValid = false;
//            }
//        }
//
//        return leftValid && rightValid;
//    }


}
