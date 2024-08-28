import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_5629 {

    static List<?> list = new ArrayList<?>();

    Object checkString(final List<?> list) {
        for (final Object s : list) {
            if (!(s instanceof String)) {
                throw new AssertionError("Not a String: " + s);
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5629().checkString(list);
    }
}
