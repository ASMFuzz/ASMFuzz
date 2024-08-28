public class MyJVMTest_3893 {

    static Class<?> staticClassBoolean = boolean.class;

    static Class<?> staticClassBooleanArray = boolean[].class;

    boolean testBooleanArray() {
        return staticClassBooleanArray.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3893().testBooleanArray());
    }
}
