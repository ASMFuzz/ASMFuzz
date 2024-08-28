public class MyJVMTest_16365 {

    static Class<?> classObject = Object.class;

    boolean testObject() {
        return classObject.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16365().testObject());
    }
}
