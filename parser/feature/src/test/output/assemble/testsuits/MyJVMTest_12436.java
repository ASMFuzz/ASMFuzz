public class MyJVMTest_12436 {

    boolean testLong() {
        return long.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12436().testLong());
    }
}
