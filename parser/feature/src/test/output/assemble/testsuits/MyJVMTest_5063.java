public class MyJVMTest_5063 {

    static Class<?> classFloat = float.class;

    boolean testFloat() {
        return classFloat.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5063().testFloat());
    }
}
