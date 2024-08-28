public class MyJVMTest_5059 {

    static Object value = 0;

    static String name = "Q-5rvO:>:)";

    String test(Object value, String name) {
        if (!value.getClass().getName().equals(name)) {
            throw new RuntimeException(name);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5059().test(value, name);
    }
}
