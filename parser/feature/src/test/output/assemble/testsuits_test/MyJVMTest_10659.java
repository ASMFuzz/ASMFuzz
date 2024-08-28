public class MyJVMTest_10659 {

    static long a = 6515114282349353250L;

    static long b = 9223372036854775807L;

    long unchecked(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10659().unchecked(a, b));
    }
}
