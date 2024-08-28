import java.util.*;

public class MyJVMTest_17481 {

    static Object[] original = { 3, 2, -1226699679, 8, 0, 0, 5, 0, 6, 7 };

    static int from = 652301699;

    static int to = 0;

    Object[] m(Object[] original, int from, int to) {
        return Arrays.copyOfRange(original, from, to, Object[].class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17481().m(original, from, to)));
    }
}
