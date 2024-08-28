public class MyJVMTest_17500 {

    static Class<?> classArray = Object[].class;

    boolean testArray() {
        return classArray.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17500().testArray());
    }
}
