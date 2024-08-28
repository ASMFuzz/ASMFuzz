import java.util.List;

public class MyJVMTest_13086 {

    <Z> List m() {
        return null;
    }

    void test() {
        List<?> l = m();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13086().test();
    }
}
