public class MyJVMTest_1018 {

    static Class<?> staticClassBoolean = boolean.class;

    boolean testBoolean() {
        return staticClassBoolean.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1018().testBoolean());
    }
}
