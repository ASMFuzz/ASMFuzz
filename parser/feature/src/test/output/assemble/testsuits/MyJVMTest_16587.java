public class MyJVMTest_16587 {

    boolean testArray() {
        return Object[].class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16587().testArray());
    }
}
