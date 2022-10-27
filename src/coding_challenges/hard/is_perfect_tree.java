package coding_challenges.hard;
import coding_challenges.TreeNode;


public class is_perfect_tree {
    static public Boolean isPerfectTree(TreeNode node) {
/*
Perfect Binary Tree Check
A binary tree is perfect when all levels are complete.
Write a method that checks if a binary tree is perfect.
coding_challenges.hard.TreeNode API methods: node.left() and node.right().
*/
        if(null==node.left() && null==node.right())
            return true;
        if(null!=node.left() && null!=node.right())
            return weigh(node.left())==weigh(node.right());
        else
            return false;
    }

    private static int weigh(TreeNode node) {
        int wl=0, wr=0;

        if ( null!=node.right() )
                wr= weigh(node.right());

        if ( null!=node.left() )
            wl=weigh(node.left());

        return (1+wl+wr);
    }

    private void printout(TreeNode node, int level) {
        for(int idx=0; idx<level;idx++)
            System.out.print("   ");

        System.out.println(node.get_value()+"="+weigh(node));
        if(null!=node.left())
            printout(node.left(),1+level);
        if(null!=node.right())
            printout(node.right(),1+level);

    }

    public void go() {
        TreeNode root = new TreeNode(0);
        root.random_populate(root, 3, 0);
        printout(root, 0);
        System.out.println("Is a perfect tree ? "+ is_perfect_tree.isPerfectTree(root));
    }


}
