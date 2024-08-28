public class MyJVMTest_13733 {

    static Class<?> classLong = long.class;

    boolean testLong() {
        return classLong.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13733().testLong());
    }
}
