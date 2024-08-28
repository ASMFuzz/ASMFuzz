import java.net.URL;

public class MyJVMTest_16432 {

    static ThreadLocal<Boolean> allowAll = new ThreadLocal<>();

    boolean allowAll() {
        Boolean allow = allowAll.get();
        if (allow != null) {
            return allow;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16432().allowAll());
    }
}
