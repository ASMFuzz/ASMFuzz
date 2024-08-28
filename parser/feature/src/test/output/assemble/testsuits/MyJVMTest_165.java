public class MyJVMTest_165 {

    static Class<?> classByte = byte.class;

    boolean testByte() {
        return classByte.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_165().testByte());
    }
}
