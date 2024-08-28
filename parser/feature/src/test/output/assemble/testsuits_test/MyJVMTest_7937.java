public class MyJVMTest_7937 {

    static Class<?> classArray = Object[].class;

    boolean testArray() {
        return classArray.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7937().testArray());
    }
}
