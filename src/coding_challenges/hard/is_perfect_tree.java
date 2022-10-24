package coding_challenges.hard;

import static java.lang.Math.random;

class TreeNode {
    private double m_value;
    private TreeNode left_child
    , right_child
    ;
    TreeNode(double v){
        left_child=null;
        right_child=null;
        m_value=v;
    }
    public void set_right(TreeNode n){
        right_child=n;
    }
    public void set_left(TreeNode n) {
        left_child = n;
    }
    public TreeNode left(){return left_child;}
    public TreeNode right(){return right_child;}

    public double get_value() {return m_value;  }
}



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

    private void random_populate(TreeNode n, int max_depth, int curr_depth){
        if(0.2>random())
            return;
        n.set_left(new TreeNode(random()));
        if(0.1>random())
            return;
        n.set_right(new TreeNode(random()));

        if(curr_depth<max_depth){
            random_populate(n.left(), max_depth, 1+curr_depth);
            random_populate(n.right(), max_depth, 1+curr_depth);
        }
    }

    public void go() {
        TreeNode root = new TreeNode(0);
        random_populate(root, 3, 0);
        printout(root, 0);
        System.out.println("Is a perfect tree ? "+ is_perfect_tree.isPerfectTree(root));
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
}
