package effective_java;

import java.io.Closeable;
import java.io.IOException;

class must_be_closed_1 implements Closeable {
    public boolean must_raise_exception;
    public try_with_resources.object_status status= try_with_resources.object_status.CLOSED;
    public must_be_closed_1(){
        must_raise_exception=false;
    }
    public void open() throws IOException {
        System.out.println("1: I am being opened!");
        status= try_with_resources.object_status.OPEN;
        if(must_raise_exception)
            throw new IOException("1: This exception is raised on purpose");
    }

    public void some_operation()throws IOException{
        if(status != try_with_resources.object_status.OPEN)
            throw new IllegalAccessError("1: Wrong status!");
        System.out.println("1: I am performing complex operations...");
        if(must_raise_exception)
            throw new IOException("2: This exception is raised on purpose." +
                    " You'll see a stack trace but it's fine.");
    }
    @Override
    public void close() throws IOException {
        if(status!= try_with_resources.object_status.OPEN)
            throw new IllegalAccessError("1: Wrong status!");

        if(true==must_raise_exception)
            throw new IOException("1: something wrong during close!");

        status= try_with_resources.object_status.CLOSED;
        System.out.println("1: I am being closed!");
    }
}



class must_be_closed_2 implements Closeable {
    public boolean must_raise_exception;
    public try_with_resources.object_status status= try_with_resources.object_status.CLOSED;
    public must_be_closed_2(){
        must_raise_exception=false;
    }
    public void open() throws IOException {
        System.out.println("2: I am being opened!");
        status= try_with_resources.object_status.OPEN;
        if(must_raise_exception)
            throw new IOException("2: something wrong during open!");
    }

    public void some_operation()throws IOException{
        if(status!= try_with_resources.object_status.OPEN)
            throw new IllegalAccessError("2: Wrong status!");
        System.out.println("2: I am performing complex operations...");
        if(must_raise_exception)
            throw new IOException("2: something wrong in an operation!");
    }
    @Override
    public void close() throws IOException {

        if(status!= try_with_resources.object_status.OPEN)
            throw new IOException("2: Wrong status!");


        if(true==must_raise_exception)
            throw new IOException("2: something wrong during close!");

        status= try_with_resources.object_status.CLOSED;
        System.out.println("2: I am closed!");
    }
}




public class try_with_resources {
    public enum object_status
    {   OPEN
    , CLOSED
    , ERROR
    }
    private void go_exception_1() {
        System.out.println("\nRaising an exception");
        try(
                must_be_closed_1 MBC1 = new must_be_closed_1();
                must_be_closed_2 MBC2 = new must_be_closed_2();
        ){
            MBC1.must_raise_exception=true;
            MBC1.open();
            MBC2.open();
            MBC1.some_operation();
            MBC2.some_operation();
        }catch(IOException exception){
            System.out.println(exception);
        }finally{
            System.out.println("Finally: neither 1 nor 2 are left open");
        }
    }

    private void go_exception_2() {
        System.out.println("\nRaising an exception in 1 some_operation");
        try(
                must_be_closed_1 MBC1 = new must_be_closed_1();
                must_be_closed_2 MBC2 = new must_be_closed_2()
        ){
            MBC1.open();
            MBC2.open();
            MBC1.must_raise_exception=true;
            MBC1.some_operation();
            MBC2.some_operation();
        }catch(IOException exception){
            exception.printStackTrace();
        }finally{
            System.out.println("Finally: there is an exception in 2 close that you see in the stack as suppressed");
        }
    }

    private void go_smooth() {
        System.out.println("\nRunning smoothly");
        try(
                must_be_closed_1 MBC1 = new must_be_closed_1();
                must_be_closed_2 MBC2 = new must_be_closed_2();
        ){
            MBC1.open();
            MBC2.open();
            MBC1.some_operation();
            MBC2.some_operation();
        }catch(IOException exception){
            exception.printStackTrace();
//            System.out.println(exception);
        }finally{
            System.out.println("Finally: the two objects have been opened and closed.");
        }
    }

    public void go() {
//        System.out.print("------- CASE 1 -------");
//        go_smooth();
//
//        System.out.print("------- CASE 2 -------");
//        go_exception_1();

        System.out.print("------- CASE 3 -------");
        go_exception_2();
        System.out.println("END");
    }

}
