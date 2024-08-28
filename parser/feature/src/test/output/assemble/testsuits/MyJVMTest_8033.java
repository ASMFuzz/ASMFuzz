import java.util.ArrayList;

public class MyJVMTest_8033 {

    void test() {
        new ArrayList<>();
        Runnable r = () -> {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8033().test();
    }
}
