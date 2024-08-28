public class MyJVMTest_6859 {

    static Class<?> classObject = Object.class;

    boolean testObject() {
        return classObject.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6859().testObject());
    }
}
