public class MyJVMTest_6300 {

    static int max = 791679036;

    static int a = 340270975;

    int verify(int max, int a) {
        if (a != (max - 1)) {
            System.out.println("Expected: " + (max - 1));
            System.out.println("Actual  : " + a);
            System.exit(97);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6300().verify(max, a);
    }
}
