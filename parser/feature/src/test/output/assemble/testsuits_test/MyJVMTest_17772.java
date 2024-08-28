import java.beans.Statement;

public class MyJVMTest_17772 {

    static Object target = 0;

    static Object params = 2;

    Object test(Object target, Object... params) throws Exception {
        new Statement(target, "m", params).execute();
        return target;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17772().test(target, params);
    }
}
