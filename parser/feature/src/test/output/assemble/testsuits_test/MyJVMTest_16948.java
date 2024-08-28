public class MyJVMTest_16948 {

    static int[] finalArr = new int[42];

    int testFinalField() {
        try {
            return finalArr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16948().testFinalField());
    }
}
