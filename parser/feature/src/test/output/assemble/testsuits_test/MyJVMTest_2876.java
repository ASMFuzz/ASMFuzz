import java.util.*;

public class MyJVMTest_2876 {

    void fail() {
        System.out.println("FAILED");
        System.exit(97);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2876().fail();
    }
}
