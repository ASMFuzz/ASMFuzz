public class MyJVMTest_15024 {

    static long[] a = { 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, 0, -2393611033311319085L, 9223372036854775807L, 0, 0 };

    long summ2(long[] a) {
        Long result1 = 1l;
        Long result2 = new Long(1);
        for (Long i : a) {
            result1 += i;
            result2 += new Long(i + 1);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15024().summ2(a));
    }
}
