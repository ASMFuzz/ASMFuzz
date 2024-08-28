public class MyJVMTest_12117 {

    static int max = 1265958633;

    void verify(int max, int a) {
        if (a != (max - 1)) {
            System.out.println("Expected: " + (max - 1));
            System.out.println("Actual  : " + a);
            System.exit(97);
        }
    }

    int loopAndPrint(int max) {
        int a = -1;
        int i = 1;
        for (; i < max; i++) {
            a = i;
        }
        verify(max, a);
        return max;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12117().loopAndPrint(max);
    }
}
