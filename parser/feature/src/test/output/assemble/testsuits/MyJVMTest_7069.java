public class MyJVMTest_7069 {

    boolean testArray() {
        return Object[].class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7069().testArray());
    }
}
