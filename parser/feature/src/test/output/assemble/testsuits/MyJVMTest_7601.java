public class MyJVMTest_7601 {

    static int st = 5;

    static int e = 1349405436;

    CharSequence subSequence(int st, int e) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7601().subSequence(st, e));
    }
}
