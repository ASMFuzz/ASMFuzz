public class MyJVMTest_17147 {

    static int st = 0;

    static int e = 0;

    CharSequence subSequence(int st, int e) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17147().subSequence(st, e));
    }
}
