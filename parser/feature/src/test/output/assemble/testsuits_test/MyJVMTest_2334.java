public class MyJVMTest_2334 {

    static Class<?> classInt = int.class;

    boolean testInt() {
        return classInt.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2334().testInt());
    }
}
