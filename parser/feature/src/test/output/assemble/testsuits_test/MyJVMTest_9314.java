public class MyJVMTest_9314 {

    static Class<?> classByte = byte.class;

    boolean testByte() {
        return classByte.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9314().testByte());
    }
}
