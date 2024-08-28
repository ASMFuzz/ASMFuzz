import java.util.ArrayList;

public class MyJVMTest_13479 {

    void test() {
        new ArrayList<>();
        new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13479().test();
    }
}
