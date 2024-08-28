import javax.security.auth.kerberos.*;

public class MyJVMTest_12046 {

    static Object o1 = 2;

    static Object o2 = 1381531892;

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
        new MyJVMTest_12046().checkSame(o1, o2);
    }
}
