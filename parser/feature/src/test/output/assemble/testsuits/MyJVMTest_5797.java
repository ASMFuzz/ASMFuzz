import java.net.*;

public class MyJVMTest_5797 {

    static String one = "Sj.!jwp/m.";

    static String two = "a]Va~~QAzy";

    static String three = "JKDO\\7}>Hi";

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
        new MyJVMTest_5797().testTriplet(one, two, three);
    }
}
