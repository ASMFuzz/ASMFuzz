public class MyJVMTest_11025 {

    static Class<?> classNull = null;

    boolean testNull() {
        return classNull.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11025().testNull());
    }
}
