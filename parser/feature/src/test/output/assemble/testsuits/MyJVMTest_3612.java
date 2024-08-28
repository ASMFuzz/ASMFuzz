public class MyJVMTest_3612 {

    static Class<?> classBoolean = boolean.class;

    static Class<?> classBooleanArray = boolean[].class;

    boolean testBooleanArray() {
        return classBooleanArray.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3612().testBooleanArray());
    }
}
