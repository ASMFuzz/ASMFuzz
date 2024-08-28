import java.io.*;

public class MyJVMTest_16009 {

    String name() {
        return "provider1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16009().name());
    }
}
