public class MyJVMTest_11580 {

    boolean testBooleanArray() {
        return boolean[].class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11580().testBooleanArray());
    }
}
