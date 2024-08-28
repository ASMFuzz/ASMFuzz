public class MyJVMTest_2320 {

    boolean testBooleanArray() {
        return boolean[].class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2320().testBooleanArray());
    }
}
