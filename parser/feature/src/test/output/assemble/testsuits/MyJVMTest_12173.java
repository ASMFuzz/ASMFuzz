import java.lang.reflect.Method;

public class MyJVMTest_12173 {

    static int counter = 0;

    int test(int counter) throws Exception {
        Method method = getClass().getDeclaredMethod("myMethod" + (counter == 0 ? "" : counter));
        method.setAccessible(true);
        method.invoke(this);
        return counter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12173().test(counter);
    }
}
