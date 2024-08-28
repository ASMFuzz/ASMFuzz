public class MyJVMTest_2651 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 0, -3742835653924418467L, -9223372036854775808L, -7522333313789956191L, 6173870963055763966L, 9223372036854775807L, -98039711893030496L, 0 };

    static Long ibc = new Long(1);

    long sumc2(long[] a) {
        Long result1 = 1l;
        Long result2 = ibc;
        for (Long i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2651().sumc2(a));
    }
}
