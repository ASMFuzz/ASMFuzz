public class MyJVMTest_18157 {

    static Class<?> staticClassNull = null;

    boolean testNull() {
        return staticClassNull.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18157().testNull());
    }
}
