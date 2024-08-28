public class MyJVMTest_290 {

    static Class<?> staticClassLong = long.class;

    boolean testLong() {
        return staticClassLong.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_290().testLong());
    }
}
