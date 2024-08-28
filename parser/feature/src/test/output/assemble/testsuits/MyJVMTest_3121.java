public class MyJVMTest_3121 {

    boolean testLong() {
        return long.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3121().testLong());
    }
}
