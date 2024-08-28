public class MyJVMTest_17428 {

    static long l1 = 9223372036854775807L;

    static long l2 = 4822760101906284323L;

    static Object[] a = { 5, 2, -1934441369, -748708552, 4, 0, 1, 1552510154, 6, 201639611 };

    long method(long l1, long l2, Object[] a) {
        return l1 + l2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17428().method(l1, l2, a));
    }
}
