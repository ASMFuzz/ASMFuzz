import java.util.concurrent.ThreadFactory;

public class MyJVMTest_5136 {

    void PrivilegedThreadPoolFactory() {
        if (PrivilegedThreadFactory.class.getClassLoader() != null)
            throw new RuntimeException("PrivilegedThreadFactory class not on boot class path");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5136().PrivilegedThreadPoolFactory();
    }
}
