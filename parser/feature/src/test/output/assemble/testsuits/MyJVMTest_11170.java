public class MyJVMTest_11170 {

    static Class<?> type = null;

    static String property = "aC5/G@,k|c";

    static boolean value = true;

    int test(Class<?> type, String property, boolean value) {
        String message = type.getSimpleName() + "(" + property + ") ";
        try {
            type.getConstructor(String.class, Class.class).newInstance(property, Test7172865.class);
            message += "passed";
        } catch (Exception exception) {
            message += "failed";
            value = !value;
        }
        if (value) {
            message += " as expected";
        }
        System.out.println(message);
        return value ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11170().test(type, property, value));
    }
}
