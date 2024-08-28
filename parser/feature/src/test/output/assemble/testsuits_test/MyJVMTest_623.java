public class MyJVMTest_623 {

    static Class<?> classDouble = double.class;

    boolean testDouble() {
        return classDouble.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_623().testDouble());
    }
}
