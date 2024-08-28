import java.util.*;

public class MyJVMTest_5453 {

    static String str = "26oN[,sR#q";

    String testFromStringError(String str) {
        try {
            UUID test = UUID.fromString(str);
            throw new RuntimeException("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5453().testFromStringError(str);
    }
}
