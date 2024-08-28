public class MyJVMTest_11091 {

    static Class<?> staticClassDouble = double.class;

    boolean testDouble() {
        return staticClassDouble.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11091().testDouble());
    }
}
