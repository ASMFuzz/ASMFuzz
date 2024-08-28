public class MyJVMTest_15609 {

    static int[] staticFinalArr = new int[42];

    int testStaticFinalField() {
        try {
            return staticFinalArr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15609().testStaticFinalField());
    }
}
