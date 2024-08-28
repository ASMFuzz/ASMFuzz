public class MyJVMTest_12060 {

    static Class<?> staticClassByte = byte.class;

    boolean testByte() {
        return staticClassByte.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12060().testByte());
    }
}
