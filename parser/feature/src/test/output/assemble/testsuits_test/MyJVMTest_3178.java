public class MyJVMTest_3178 {

    static Class<?> classBoolean = boolean.class;

    boolean testBoolean() {
        return classBoolean.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3178().testBoolean());
    }
}
