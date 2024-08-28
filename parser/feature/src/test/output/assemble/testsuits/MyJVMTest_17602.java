import java.util.ArrayList;

public class MyJVMTest_17602 {

    void test() {
        new ArrayList<>();
        Runnable r = () -> {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17602().test();
    }
}
