public class MyJVMTest_11278 {

    static int a = -738857598;

    static int b = 291917476;

    int checkMethod(int a, int b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11278().checkMethod(a, b));
    }
}
