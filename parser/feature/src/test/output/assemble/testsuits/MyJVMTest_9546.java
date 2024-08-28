import java.lang.reflect.Constructor;

public class MyJVMTest_9546 {

    void sync_shouldnt_be_tested() {
    }

    static Method m = null;

    static Object target = 0;

    static Object[] args = {0,0,0,3,7,-1916198958,0,-2107229071,4,1060563856};

    void should_pass() {
        sync_shouldnt_be_tested();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9546().should_pass();
    }
}
