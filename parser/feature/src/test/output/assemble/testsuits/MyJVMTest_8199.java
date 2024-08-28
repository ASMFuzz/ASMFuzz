import java.beans.Statement;

public class MyJVMTest_8199 {

    static Object target = 0;

    static Object params = 5;

    Object test(Object target, Object... params) throws Exception {
        new Statement(target, "m", params).execute();
        return target;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8199().test(target, params);
    }
}
