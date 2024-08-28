public class MyJVMTest_1986 {

    static Class<?> classShort = short.class;

    boolean testShort() {
        return classShort.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1986().testShort());
    }
}
