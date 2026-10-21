import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> trees = new ArrayList<>();

        if (low > high) {
            trees.add(null);
            return trees;
        }

        for (int rootValue = low; rootValue <= high; rootValue++) {
            List<TreeNode> leftTrees = build(low, rootValue - 1);
            List<TreeNode> rightTrees = build(rootValue + 1, high);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }
}

