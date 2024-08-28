import java.lang.invoke.*;

public class MyJVMTest_4981 {

    static String testName = "G=gTdPSop ";

    static Class<? extends Throwable> expectedError = null;

    static MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    static MethodType TEST_MT = MethodType.methodType(void.class);

    static Class<?> TEST_CLASS = null;

    String test(String testName, Class<? extends Throwable> expectedError) {
        System.out.print(testName);
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
        System.out.println(": PASSED");
        return testName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4981().test(testName, expectedError);
    }
}
