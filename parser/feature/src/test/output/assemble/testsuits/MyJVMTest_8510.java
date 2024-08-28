import java.beans.Expression;

public class MyJVMTest_8510 {

    static Object target = 0;

    static String name = "!qh;Yf 1)W";

    static Object args = 8;

    Object testInt(Object target, String name, Object... args) throws Exception {
        return new Expression(target, name, args).getValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8510().testInt(target, name, args));
    }
}
