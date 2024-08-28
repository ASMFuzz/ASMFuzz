public class MyJVMTest_7866 {

    static long l1 = 9223372036854775807L;

    static long l2 = -4021561717708951532L;

    static Object[] a = { 2, -784283586, 9, -1672748375, 0, -248790769, 4, 0, 1, 0 };

    long method(long l1, long l2, Object[] a) {
        return l1 + l2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7866().method(l1, l2, a));
    }
}
