public class MyJVMTest_10796 {

    static long num1 = -9223372036854775808L;

    static int _fCreationYear = 1;

    int mod7(long num1) {
        int rem = (int) (num1 % 7);
        if (num1 < 0 && rem < 0)
            return rem + 7;
        return rem;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10796().mod7(num1));
    }
}
