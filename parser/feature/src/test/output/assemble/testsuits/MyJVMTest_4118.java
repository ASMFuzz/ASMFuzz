import java.util.ArrayList;

public class MyJVMTest_4118 {

    void test() {
        new ArrayList<>();
        new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4118().test();
    }
}
