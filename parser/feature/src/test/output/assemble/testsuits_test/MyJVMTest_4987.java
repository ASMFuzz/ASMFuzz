import javax.security.auth.kerberos.*;

public class MyJVMTest_4987 {

    static Object o1 = 9;

    static Object o2 = 0;

    Object checkNotSame(Object o1, Object o2) {
        if (o1.equals(o2)) {
            throw new RuntimeException("equals() succeeds");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4987().checkNotSame(o1, o2);
    }
}
