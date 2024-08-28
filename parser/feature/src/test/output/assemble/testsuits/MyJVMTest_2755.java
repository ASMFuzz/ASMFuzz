import javax.security.auth.kerberos.*;

public class MyJVMTest_2755 {

    static Object o1 = 4;

    static Object o2 = 0;

    Object checkSame(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new RuntimeException("equals() fails");
        }
        if (o1.hashCode() != o2.hashCode()) {
            throw new RuntimeException("hashCode() not same");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2755().checkSame(o1, o2);
    }
}
