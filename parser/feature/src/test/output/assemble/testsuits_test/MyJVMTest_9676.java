public class MyJVMTest_9676 {

    static Class<?> staticClassFloat = float.class;

    boolean testFloat() {
        return staticClassFloat.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9676().testFloat());
    }
}
