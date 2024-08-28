import java.util.concurrent.*;
import java.lang.reflect.*;

public class MyJVMTest_8902 {

    static String string = "FRe7;%RyH ";

    static Field valueField = null;

    static String s = "r]X,E\\Za[2";

    static Object value = 1420349466;

    static long valuePointer = 0;

    Object getValue(String string) {
        try {
            return valueField.get(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8902().getValue(string));
    }
}
