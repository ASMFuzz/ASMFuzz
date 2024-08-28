public class MyJVMTest_15778 {

    static int max = -1506270364;

    static int a = 2;

    int verify(int max, int a) {
        if (a != (max - 1)) {
            System.out.println("Expected: " + (max - 1));
            System.out.println("Actual  : " + a);
            System.exit(97);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15778().verify(max, a);
    }
}
