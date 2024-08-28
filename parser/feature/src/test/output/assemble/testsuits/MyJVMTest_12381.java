public class MyJVMTest_12381 {

    boolean testBoolean() {
        return boolean.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12381().testBoolean());
    }
}
