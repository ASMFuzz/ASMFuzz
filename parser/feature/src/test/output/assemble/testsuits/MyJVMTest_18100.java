import java.beans.Expression;

public class MyJVMTest_18100 {

    static Object target = 7;

    static String name = "$\\\"7nK/t%1";

    static Object args = -636820627;

    Object testInt(Object target, String name, Object... args) throws Exception {
        return new Expression(target, name, args).getValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18100().testInt(target, name, args));
    }
}
