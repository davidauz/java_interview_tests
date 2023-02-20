package coding_challenges.medium;

import coding_challenges.TreeNode;

public class strict_binary_tree {
//    Strict Binary Tree Check
//    A binary tree is strict when all nodes have either two or zero child nodes.
//    Write a method that checks if a binary tree is strict.
//    TreeNode API methods: node.left() and node.right().

    private void printout(TreeNode node, int level) {
        for(int idx=0; idx<level;idx++)
            System.out.print("   ");

        System.out.println(node.get_value());
        if(null!=node.left())
            printout(node.left(),1+level);
        if(null!=node.right())
            printout(node.right(),1+level);

    }

    private boolean is_strict_binary(TreeNode node) {
        if(null==node.left() && null!=node.right())
            return false;
        if(null==node.right() && null!=node.left())
            return false;
        if(null==node.right() && null==node.left())
            return true;
        return (is_strict_binary(node.left()) && is_strict_binary(node.right()));
    }


    public void go() {
        TreeNode root = new TreeNode(0);
        root.random_populate(root, 3, 0);
        printout(root, 0);
        System.out.println("Is a perfect tree ? "+ is_strict_binary(root));
    }


}
