import java.util.*;

public class MyJVMTest_15255 {

    static Map.Entry<Integer, Long> o1 = null;

    static Map.Entry<Integer, Long> o2 = null;

    static int TEST_SIZE = 5000;

    static Integer[] KEYS = new Integer[TEST_SIZE];

    static Long[] VALUES = new Long[TEST_SIZE];

    int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
        return o1.getKey().compareTo(o2.getKey());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15255().compare(o1, o2));
    }
}
