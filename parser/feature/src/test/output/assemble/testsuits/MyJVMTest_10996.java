import java.util.ArrayList;

public class MyJVMTest_10996 {

    void m1() throws Throwable {
        @SuppressWarnings("unchecked")
        final ArrayList[] v3 = { new ArrayList() {
        } };
        @SuppressWarnings("unchecked")
        ArrayList[] v4 = { new ArrayList() {
        } };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10996().m1();
    }
}
