import java.lang.invoke.*;

public class MyJVMTest_2455 {

    static String testName = "JY\"ylJBqq?";

    static Class<? extends Throwable> expectedError = null;

    static MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    static MethodType TEST_MT = MethodType.methodType(void.class);

    static Class<?> TEST_CLASS = null;

    String test(String testName, Class<? extends Throwable> expectedError) {
        try {
            LOOKUP.findStatic(TEST_CLASS, testName, TEST_MT).invokeExact();
        } catch (Throwable e) {
            if (expectedError.isInstance(e)) {
            } else {
                e.printStackTrace();
                String msg = String.format("%s: wrong exception: %s, but %s expected", testName, e.getClass().getName(), expectedError.getName());
                throw new AssertionError(msg);
            }
        }
        return testName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2455().test(testName, expectedError);
    }
}
