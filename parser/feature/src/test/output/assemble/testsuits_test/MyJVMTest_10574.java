import java.util.*;

public class MyJVMTest_10574 {

    static E[] values = { null, null, null, null, null, null, null, null, null, null };

    <E extends Enum<E>> E[] f(E[] values) {
        for (E e : values) {
            System.out.println(e);
        }
        return values;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10574().f(values);
    }
}
