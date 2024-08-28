public class MyJVMTest_10137 {

    static int a = 4;

    static int b = 0;

    int checkMethod(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10137().checkMethod(a, b));
    }
}
