public class MyJVMTest_14476 {

    static Class<?> classFloat = float.class;

    boolean testFloat() {
        return classFloat.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14476().testFloat());
    }
}
