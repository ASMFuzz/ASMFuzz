public class MyJVMTest_1934 {

    static Class<?> type = null;

    static String property = "c<b?OI/w;p";

    static boolean value = false;

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
        System.out.println(new MyJVMTest_1934().test(type, property, value));
    }
}
