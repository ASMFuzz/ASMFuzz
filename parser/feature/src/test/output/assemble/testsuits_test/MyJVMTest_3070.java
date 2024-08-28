public class MyJVMTest_3070 {

    boolean testBoolean() {
        return boolean.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3070().testBoolean());
    }
}
