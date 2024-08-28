public class MyJVMTest_16974 {

    static long a = -3455649982610439787L;

    static long b = -9223372036854775808L;

    long unchecked(long a, long b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16974().unchecked(a, b));
    }
}
