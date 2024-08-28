public class MyJVMTest_12494 {

    static Class<?> classBoolean = boolean.class;

    boolean testBoolean() {
        return classBoolean.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12494().testBoolean());
    }
}
