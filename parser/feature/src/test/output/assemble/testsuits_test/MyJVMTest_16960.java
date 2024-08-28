import java.net.URL;

public class MyJVMTest_16960 {

    static boolean allow = false;

    static ThreadLocal<Boolean> allowAll = new ThreadLocal<>();

    boolean setAllowAll(boolean allow) {
        allowAll.set(allow);
        return allow;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16960().setAllowAll(allow);
    }
}
