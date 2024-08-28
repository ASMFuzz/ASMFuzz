public class MyJVMTest_11596 {

    static Class<?> staticClassShort = short.class;

    boolean testShort() {
        return staticClassShort.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11596().testShort());
    }
}
