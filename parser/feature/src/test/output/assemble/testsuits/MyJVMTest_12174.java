import java.util.*;

public class MyJVMTest_12174 {

    void fail() {
        System.out.println("FAILED");
        System.exit(97);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12174().fail();
    }
}
