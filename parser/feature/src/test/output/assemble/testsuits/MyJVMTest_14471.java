public class MyJVMTest_14471 {

    static Object value = 0;

    static String name = "qYi{\"J3):!";

    String test(Object value, String name) {
        if (!value.getClass().getName().equals(name)) {
            throw new RuntimeException(name);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14471().test(value, name);
    }
}
