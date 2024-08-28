public class MyJVMTest_1800 {

    static Class<?> classNull = null;

    boolean testNull() {
        return classNull.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1800().testNull());
    }
}
