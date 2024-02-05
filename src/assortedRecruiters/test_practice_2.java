package assortedRecruiters;

import java.util.ArrayList;

public class test_practice_2 {


        class Solution {
            public static int calPoints(String[] ops) {
                int sum = 0
                ,   temp=0
                ,   my_val=0
                ;
                ArrayList<Integer> a_list = new ArrayList<Integer>();
                for(String oneOp: ops){
                    switch(oneOp){
                        case "+"-> {
                            temp = a_list.size();
                            my_val = a_list.get(temp - 1) + a_list.get(temp - 2);
                            a_list.add(my_val);
                        }
                        case "C"-> {
                            temp = a_list.size();
                            a_list.remove(temp - 1);
                        }
                        case "D"-> {
                            temp = a_list.size();
                            my_val = 2 * a_list.get(temp - 1);
                            a_list.add(my_val);
                        }
                        default->a_list.add(Integer.valueOf(oneOp));
                    }
                }

                for(int i=0; i<a_list.size(); i++)
                    sum = sum + a_list.get(i);

                return  sum;

            }
        }
    }

