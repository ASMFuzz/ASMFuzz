public class MyJVMTest_11594 {

    static Class<?> classInt = int.class;

    boolean testInt() {
        return classInt.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11594().testInt());
    }
}
