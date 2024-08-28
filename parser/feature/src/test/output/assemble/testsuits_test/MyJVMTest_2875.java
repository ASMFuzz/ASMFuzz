import java.lang.reflect.Method;

public class MyJVMTest_2875 {

    static int counter = 2;

    int test(int counter) throws Exception {
        Method method = getClass().getDeclaredMethod("myMethod" + (counter == 0 ? "" : counter));
        method.setAccessible(true);
        method.invoke(this);
        return counter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2875().test(counter);
    }
}
