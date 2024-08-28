import java.util.List;

public class MyJVMTest_3747 {

    <Z> List m() {
        return null;
    }

    void test() {
        List<?> l = m();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3747().test();
    }
}
