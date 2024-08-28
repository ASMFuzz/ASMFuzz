public class MyJVMTest_8992 {

    static long a = -2762462588884449864L;

    static long b = 2051775756394078482L;

    static long c = 9223372036854775807L;

    long test(long a, long b, long c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8992().test(a, b, c));
    }
}
