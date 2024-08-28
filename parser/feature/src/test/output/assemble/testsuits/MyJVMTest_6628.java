import java.io.*;

public class MyJVMTest_6628 {

    Throwable getCause() {
        return new Throwable("always new");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6628().getCause());
    }
}
