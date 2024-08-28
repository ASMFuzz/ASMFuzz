public class MyJVMTest_9442 {

    static Class<?> staticClassLong = long.class;

    boolean testLong() {
        return staticClassLong.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9442().testLong());
    }
}
