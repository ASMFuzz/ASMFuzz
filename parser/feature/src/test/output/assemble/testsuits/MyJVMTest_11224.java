public class MyJVMTest_11224 {

    static Class<?> classShort = short.class;

    boolean testShort() {
        return classShort.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11224().testShort());
    }
}
