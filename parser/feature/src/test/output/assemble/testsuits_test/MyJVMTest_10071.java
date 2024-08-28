public class MyJVMTest_10071 {

    static Object value = 9;

    static String name = "R&Q}d\"?z\",";

    String test(Object value, String name) {
        if (!value.getClass().getName().equals(name)) {
            throw new Error(name);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10071().test(value, name);
    }
}
