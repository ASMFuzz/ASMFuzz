public class MyJVMTest_7416 {

    static int[] finalArr = new int[42];

    int testFinalField() {
        try {
            return finalArr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7416().testFinalField());
    }
}
