import java.net.URL;

public class MyJVMTest_6922 {

    static ThreadLocal<Boolean> allowAll = new ThreadLocal<>();

    boolean allowAll() {
        Boolean allow = allowAll.get();
        if (allow != null) {
            return allow;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6922().allowAll());
    }
}
