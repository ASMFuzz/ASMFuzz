import java.util.*;

public class MyJVMTest_13998 {

    static T t1 = null;

    static T t2 = null;

    <T> boolean equal(T t1, T t2) {
        return (t1 == null ? t2 == null : t1.equals(t2));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13998().equal(t1, t2));
    }
}
