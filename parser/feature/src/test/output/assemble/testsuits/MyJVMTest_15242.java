import java.net.*;

public class MyJVMTest_15242 {

    static String one = "z*m@hay!J>";

    static String two = "~vK*i/[R(L";

    static String three = "hTI8lc{f[I";

    String testTriplet(String one, String two, String three) throws Exception {
        if (one.compareToIgnoreCase(two) > 0)
            throw new RuntimeException("Comparison failure1");
        if (two.compareToIgnoreCase(three) > 0)
            throw new RuntimeException("Comparison failure2");
        if (three.compareToIgnoreCase(one) < 0)
            throw new RuntimeException("Comparison failure3");
        return three;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15242().testTriplet(one, two, three);
    }
}
