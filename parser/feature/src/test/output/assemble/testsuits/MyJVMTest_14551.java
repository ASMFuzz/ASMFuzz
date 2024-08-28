import java.util.concurrent.ThreadFactory;

public class MyJVMTest_14551 {

    void PrivilegedThreadPoolFactory() {
        if (PrivilegedThreadFactory.class.getClassLoader() != null)
            throw new RuntimeException("PrivilegedThreadFactory class not on boot class path");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14551().PrivilegedThreadPoolFactory();
    }
}
