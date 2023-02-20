package coding_challenges;

import static java.lang.Math.random;

public class TreeNode {
    private double m_value;
    private TreeNode left_child
            , right_child
            ;
    public TreeNode(double v){
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

    public void random_populate(TreeNode n, int max_depth, int curr_depth){
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

}