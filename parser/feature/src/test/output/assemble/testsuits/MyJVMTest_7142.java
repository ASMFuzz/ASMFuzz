import java.util.List;

public class MyJVMTest_7142 {

    <Z> List<Z> m() {
        return null;
    }

    void test() {
        List<String> ls = m();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7142().test();
    }
}
