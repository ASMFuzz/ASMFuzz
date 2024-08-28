public class MyJVMTest_4359 {

    static Class<?> classLong = long.class;

    boolean testLong() {
        return classLong.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4359().testLong());
    }
}
