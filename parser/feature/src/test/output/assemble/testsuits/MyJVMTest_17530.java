import java.util.concurrent.*;
import java.lang.reflect.*;

public class MyJVMTest_17530 {

    static String string = "5#pS d9OYV";

    static Field valueField = null;

    static String s = "3T>;c*l\\Ot";

    static Object value = 2;

    static long valuePointer = 0;

    Object getValue(String string) {
        try {
            return valueField.get(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17530().getValue(string));
    }
}
