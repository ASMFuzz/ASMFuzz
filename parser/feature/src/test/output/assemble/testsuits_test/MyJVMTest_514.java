public class MyJVMTest_514 {

    static Class<?> staticClassFloat = float.class;

    boolean testFloat() {
        return staticClassFloat.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_514().testFloat());
    }
}
