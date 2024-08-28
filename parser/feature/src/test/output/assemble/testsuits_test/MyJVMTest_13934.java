public class MyJVMTest_13934 {

    static Class<?> staticClassArray = Object[].class;

    boolean testArray() {
        return staticClassArray.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13934().testArray());
    }
}
