public class MyJVMTest_6140 {

    static int[] staticFinalArr = new int[42];

    int testStaticFinalField() {
        try {
            return staticFinalArr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6140().testStaticFinalField());
    }
}
