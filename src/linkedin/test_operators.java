package linkedin;

public class test_operators {
    public void go() {
        boolean b1 = true
        ,   b2 = false
        ;
        int i1 = 11
        , i2 = 22
        ;
        System.out.println("integers:");
        System.out.println("i1=`"+i1+"`, i2=`"+i2+"`, (i1 | i2)=`"+(i1 | i2)+"`");
        System.out.println("i1=`"+i1+"`, i2=`"+i2+"`, (i1 ^ i2)=`"+(i1 ^ i2)+"`");
        System.out.println("i1=`"+i1+"`, i2=`"+i2+"`, (i1 & i2)=`"+(i1 & i2)+"`");
        System.out.println("booleans:");
        System.out.println("b1=`"+b1+"`, b2=`"+b2+"`, (b1 | b2)=`"+(b1 | b2)+"`");
        System.out.println("b1=`"+b1+"`, b2=`"+b2+"`, (b1 ^ b2)=`"+(b1 ^ b2)+"`");
        System.out.println("b1=`"+b1+"`, b2=`"+b2+"`, (b1 || b2)=`"+(b1 || b2)+"`");
        System.out.println("b1=`"+b1+"`, b2=`"+b2+"`, (b1 && b2)=`"+(b1 && b2)+"`");
    }
}
