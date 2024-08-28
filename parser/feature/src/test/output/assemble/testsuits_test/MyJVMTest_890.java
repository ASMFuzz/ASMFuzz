public class MyJVMTest_890 {

    static Object value = 6;

    static String name = "xB:ONAfnG\"";

    String test(Object value, String name) {
        if (!value.getClass().getName().equals(name)) {
            throw new Error(name);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_890().test(value, name);
    }
}
