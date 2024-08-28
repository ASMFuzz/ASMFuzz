import java.io.*;

public class MyJVMTest_16124 {

    Throwable getCause() {
        return new Throwable("always new");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16124().getCause());
    }
}
