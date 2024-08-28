import java.lang.reflect.Constructor;

public class MyJVMTest_389 {

    void sync_shouldnt_be_tested() {
    }

    static Method m = null;

    static Object target = 2;

    static Object[] args = {0,0,0,0,0,0,0,1,0,0};

    void should_pass() {
        sync_shouldnt_be_tested();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_389().should_pass();
    }
}
