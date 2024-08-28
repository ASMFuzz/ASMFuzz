public class MyJVMTest_12419 {

    static long[] a = { 0, -9223372036854775808L, -9223372036854775808L, -4439139659767976800L, 7949701684777367168L, -9223372036854775808L, -2451197806296506727L, 9223372036854775807L, -9223372036854775808L, 0 };

    long sumb2(long[] a) {
        Long result1 = 1l;
        Long result2 = 1l;
        for (Long i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12419().sumb2(a));
    }
}
