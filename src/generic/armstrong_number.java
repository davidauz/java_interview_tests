package generic;

public class armstrong_number {
//    A number is called an Armstrong number if it is equal to the cube of its every digit.
//    For example, 153 is an Armstrong number because of 153= 1+ 125+27, which is equal to 1^3+5^3+3^3.
//    Write a program to check if the given number is Armstrong number or not.

    private void test_armstrong_number(int arg) {
        int running_number=arg
        ,   last_digit
        ,   sumOfCubes=0
        ,   i=arg
        ;
        do{
            last_digit=running_number%10;
            running_number=(int)(running_number / 10);
            sumOfCubes+=(last_digit*last_digit*last_digit);
        }while (0!=running_number);
        if(sumOfCubes==arg)
            System.out.println("`"+arg+"` is an Armstrong number!");
        else
            System.out.println(arg);
    }

    public void go() {
        int[] numbers_to_test=new int[] {1, 153, 370, 765, 778, 371, 9999};
        for(int idx=0; idx<numbers_to_test.length; idx++)
            test_armstrong_number(numbers_to_test[idx]);
    }


}
