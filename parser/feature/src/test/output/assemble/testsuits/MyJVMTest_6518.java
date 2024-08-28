import java.io.*;

public class MyJVMTest_6518 {

    String name() {
        return "provider1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6518().name());
    }
}
