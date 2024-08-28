import java.net.URL;

public class MyJVMTest_7427 {

    static boolean allow = false;

    static ThreadLocal<Boolean> allowAll = new ThreadLocal<>();

    boolean setAllowAll(boolean allow) {
        allowAll.set(allow);
        return allow;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7427().setAllowAll(allow);
    }
}
